# [Spring] - Spring Cloud Config

## 1. Spring Cloud Config 란?

- Spring Cloud Config 란 분산 시스템에서 **외부화된 설정 정보**를 서버 및 클라이언트에게 제공하는 시스템
- **설정 서버(Config Server)**는 외부에서 모든 환경에 대한 정보들을 관리해주는 중앙서버
    - Spring Cloud Config Server(설정 서버): 버전 관리 레포지토리로 백업된 중앙 집중식 구성 노출을 지원한다.
    - Spring Cloud Config Client(설정 클라이언트) : 애플리케이션이 설정 서버에 연결하도록 지원한다.
- 설정을 위한 별도의 서버를 구성하기 때문에 실행 중인 애플리케이션이 서버에서 설정 정보를 받아와 갱신하는 방식

## 2. Spring Cloud Config 의 특징

- 여러 서버의 설정 파일을 중앙 서버에서 관리할 수 있다
- 서버를 재배포 하지 않고 설정 파일의 변경사항을 반영할 수 있다
- Git 서버 또는 설정 서버에 의한 장애가 전파될 수 있다
- 우선 순위에 의해 설정 정보가 덮어 씌워 질 수 있다

```
✏️ **Spring Cloud Config 설정 파일 우선 순위**
	설정 파일은 크게 다음의 위치에 존재할 수 있으며 나중에 읽어지는 것이 우선순위가 높음

	1. 프로젝트의 application.yaml
	2. 설정 저장소의 application.yaml
	3. 프로젝트의 application-{profile}.yaml
	4. 설정 저장소의 {application name}/{application name}-{profile}
```

## 3. Spring Cloud Config 의 동작 과정

1. 클라이언트는 서버로 설정값을 요청
2. 서버는 설정 파일이 위치한 Git 저장소에 접근
3. 서버는 Git 저장소로부터 최신 설정값을 받고 클라이언트는 다시 서버를 통해 최신 설정값을 받음
4. 사용자가 설정 파일을 변경하고 Git 저장소를 업데이트했다면 ,애플리케이션(클라이언트)의 `actuator/refresh`엔드 포인트를 호출하여 설정값을 변경해야함
    - 여기서 엔드포인트는 각각의 애플리케이션에서 호출되어야함

## 4. Spring Cloud Config 구현

**[Spring Cloud Config Server]**

1. **설정 파일 저장소 세팅**

`{앱이름}-{프로파일}.yml` 의 구조로 **[git 에 저장소](https://github.com/januarry22/spring-config-cloud/blob/main/local/webflux-local.yml)**를 생성 한다.

```yaml
com:
  januarry22:
    webflux:
    profile: local
    region: webflux
```

1. **설정 서버 세팅**

**application.yml 작성**

```yaml
server:
  port: 8888
spring:
  application:
    name: config
  cloud:
    config:
      server:
        git:
          uri: https://github.com/januarry22/spring-config-cloud.git
          search-paths: local/**
          default-label: main
```

- uri : 설정파일이 있는 깃 주소
- default-label : 깃 주소의 브랜치 이름
- search-paths : 설정 파일들을 찾을 경로

**Dependency 추가**

- Gradle 사용 시 build.gradle
    
    ```yaml
    dependencies {
    		...
    
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
    
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
        implementation 'org.springframework.cloud:spring-cloud-config-server'
    }
    ```
    
- Maven 사용 시 pom.xml
    
    ```java
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.4.RELEASE</version>
        <relativePath/>
    </parent>
    
    <properties>
        <java.version>1.8</java.version>
        <spring-cloud.version>Hoxton.SR1</spring-cloud.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
    </dependencies>
    
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    ```
    

**Main 클래스에 EnableConfigServer 어노테이션** 

```java
@SpringBootApplication
@EnableConfigServer
public class RunWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunWebFluxApplication.class, args);
	}

}
```

1. **설정 서버 실행 및 확인**

서버를 실행하면 설정 파일 저장소를 클론하고 설정정보를 읽어오는데, 이때 spring cloud config server 가 가지게 되는 endpoint

- /{application}/{profile}[/{label}]
- /{application}-{profile}.yml
- /{label}/{application}-{profile}.yml
- /{application}-{profile}.properties
- /{label}/{application}-{profile}.properties

```yaml
**localhost:8888/{앱이름}/{프로파일}**
```

**서버로 요청**

`http://localhost:8888/webflux/kr-local`

```json
{
"name":"webflux",
"profiles":[
"kr-local"
],
"label":null,
"version":"eca8e22d34c94b931d95dcd01551ec10f8d41ec4",
"state":null,
"propertySources":[
{
		"name":"https://github.com/januarry22/spring-config-cloud.git/webflux/local/webflux-kr-local.yml",
		"source":{
			"com.januarry22.webflux":"",
			"com.januarry22.profile":"local",
			"com.januarry22.region":"kr"
		}
		}
	]
}
```

**[Spring Cloud Config Client]**

1. 클라이언트 서버 구성

**Dependency 추가**

- Gradle 사용 시 build.gradle
    
    ```yaml
    dependencies {
    		...
    
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
    
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    	  implementation 'org.springframework.cloud:spring-cloud-starter-config'
    }
    ```
    
- Maven 사용 시 pom.xml 
****

2. 설정 정보 읽어올 수 있게 코드 추가 

**application.yml 작성**

```yaml
spring:
  application:
    name: config
  profiles:
    active: kr-local
  config:
    import: optional:configserver:http://localhost:8888
```

**MainClass** `@EnableConfigurationProperties` **어노테이션 추가**

```java
@EnableConfigurationProperties(ConfigProperties.class)
@SpringBootApplication
public class RunWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunWebFluxApplication.class, args);
	}

}
```

**설정 정보를 읽어올 Preperties 클래스 추가**

```java

@Setter
@Getter
@ConfigurationProperties("com.januarry22")
@RefreshScope
@ToString
public class ConfigProperties {

		private String profile;
    private String region;
}
```

- @RefreshScope 가 설정정보가 변경되면 정보를 다시 불러올 수 있도록 해줌

**Controller 추가**

```java
@RestController
@RequiredArgsConstructor
public class ConfigClientController {
    
		private final ConfigProperties configProperties;

    @GetMapping("/config")
    public ResponseEntity<String> config() {
        System.out.println(configProperties);
        return ResponseEntity.ok(configProperties.toString());
    }
}
```

1. 클라이언트 실행 및 확인

클라이언트 서버를 정상적으로 호출하는지 확인