# [Spring] - Spring AOP

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-aop</artifactId>
</dependency>

## 1. Spring AOP 란 ?

- AOP(**Aspect Oriented Programming)의 약자로 관점 지향 프로그래밍을 의미**
- 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 이 관점들을 기준으로 모듈화 하는 것  ****
- 소스 코드 상의 반복되는 부분들**(흩어진 관심사, Crosscutting Concerns)**를  **Aspect(종단면 관점)로 모듈화 시키고 핵심적인 비즈니스로직에서 분리하여 재사용 하는 것**이 목표

## 2. Spring AOP 의 특징

- Spring Bean에만 적용이 가능
- 별도의 복잡한 설정 없이 적용 가능
- 프록시 기반의 AOP 구현체로, 프록시 객체를 사용하는 이유는 접근 제어 및 부가 기능을 추가하기 위함
- 모든 AOP를 제공하는 것이 목적이 아님. **중복코드, 프록시 클래스 작성의 번거로움, 객체간 관계 복잡도 증가 등** 엔터프라이즈급 애플리케이션에서 흔히 발생하는 문제를 해결하는 것이 주요 목적

### ✔️ Filter, Interceptor, AOP 의 차이점

**1) Filter**

Filter는 Spring이 실행 되기전 WAS단에서 처리되며 Spring과 무관하게 전역적으로 처리해야 하는 작업을 할때 사용됨
-  공통된 인증/인가 관련 작업 (XSS방어)
-  이미지/데이터 압축 및 인코딩 변환 처리
-  로그인 관련 세션 처리
-  Spring 과 무관한 작업
-  web.xml 에 설정

```xml
<filter>
    <filter-name>encoding</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>

<filter-mapping>
    <filter-name>encoding</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

 - **필터의 실행 메서드**

```xml
ㆍinit() - 필터 인스턴스 초기화
ㆍdoFilter() - 전/후 처리
ㆍdestroy() - 필터 인스턴스 종료
```

2**) Interceptor**

요청을 가로채 전/후 작업을 수행. Dispatcher Servlet에 Interceptor를 등록하면 해당 요청을 처리 가능한 Interceptor에 할당해줌

여러개 사용 할 수 있으며 로그인 체크, 권한체크, 프로그램 실행시간 계산작업 로그확인 등의 업무처리

 - 세부적인 보안 및 인증/인가 공통 작업

 - API호출에 대한 로깅 작업 

 - Controller로 넘겨주는 정보(데이터)의 가공

 - **HandlerInterceptor인터페이스 구현 / HandlerInterceptorAdapter 클래스를 상속 받아 사용**

 - **Interceptor의 실행 메서드**

```xml
ㆍpreHandler() - 컨트롤러 메서드가 실행되기 전
ㆍpostHanler() - 컨트롤러 메서드 실행직 후 view페이지 렌더링 되기 전
ㆍafterCompletion() - view페이지가 렌더링 되고 난 후
```

3**) AOP**

URL 기반이 아닌 PointCut 단위로 동작, 비즈니스 로직의 메서드를 기준으로 실행 전과 후를 쉽게 핸들링함

 - 비즈니스단의 메서드를 세부적으로 조정할 때 사용

## 3. Spring AOP 주요 개념

- **Aspect**
    
    흩어진 관심사를 모듈화 한 것
    
- **Advice**
    
    특정 join point나 Aspect에 실질적으로 어떤 일을 해야할 지에 대한 실질적인 부가기능을 담은 구현체
    
- **JointPoint**
    
    메서드 진입 지점, 생성자 호출 시점 등 프로그램이 실행 되고 있는 시점으로 Advice가 적용될 위치를 의미
    
- **PointCut** : JointPoint의 한종류이며 상세한 스펙을 정의한 것으로 더욱 구체적으로 Advice가 실행될 지점을 정할 수 있음
- **Target object** : Aspect를 적용하는 곳. 하나 또는 그 이상의 Aspect에 의해 Advised되는 객체

## 4.  Spring AOP를 사용하여 모든 요청에 대한 로그 남기기

- dependency 추가

```xml
<!-- Maven -->
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
</dependency>

<!-- Gradle -->
dependencies {
  // 생략
  compile('org.springframework.boot:spring-boot-starter-aop')
}
```

- Anotation 적용

```java
@SpringBootApplication
@EnableConfigurationProperties
@EnableAspectJAutoProxy
public class OneourbeApplication {
	// Main 클래스에 적용
	public static void main(String[] args) {
		SpringApplication.run(OneourbeApplication.class, args);
	}

}
```

- @Aspect 클래스 만들기

```java
@Aspect
@Component 
public class logAop {
		// 어노테이션 적용
    static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    /*요청(전체) 포인트컷*/
    @Around("execution(* com.api.oneourbe.api.controller..*.*(..)) ")
    public Object requestAll(ProceedingJoinPoint joinPoint) throws Throwable { //
       ...
			// 전체 요청에 대한 요청/응답 데이터 처리 
    }

    /*GET 포인트컷*/
    @Pointcut("execution(* com.api.oneourbe.api.controller.*.*RestController.*(..)) && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void requestGet(){}
		

    /*GET 컨트롤러 실행전*/
    @Before("requestGet()")
    public void doBeforeGet(JoinPoint joinPoint) throws Throwable {
	       ...
				// Request 파라미터, 헤더, 메서드정보 등 출력
    }
    /*GET 리턴시*/
    @AfterReturning(returning = "result", pointcut = "requestGet()")
    public void doAfterReturningGet(Object result) throws Throwable {
        // Response 에 대한 출력 등 처리
    }

    /*POST 포인트컷*/
    @Pointcut("execution(* com.api.oneourbe.api.controller.*.*RestController.*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void requestPost(){}

    /*POST 컨트롤러 실행전*/
    @Before("requestPost() && args(.., @RequestBody body)")
    public void  doBeforePost(JoinPoint joinPoint, final Object body) throws Throwable {
       // 처리
    }

    /*POST 리턴시*/
    @AfterReturning(returning = "result", pointcut = "requestPost()")
    public void doAfterReturningPost(Object result) throws Throwable {
        // 처리
    }
....
}
```

- @Before (이전) : 어드바이스 타겟 메소드가 호출되기 전에 어드바이스 기능을 수행
- @After (이후) : 타겟 메소드의 결과에 관계없이(즉 성공, 예외 관계없이) 타겟 메소드가 완료 되면 어드바이스 기능을 수행
- @AfterReturning (정상적 반환 이후)타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행
- @AfterThrowing (예외 발생 이후) : 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행
- @Around (메소드 실행 전후) : 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출전과 후에 어드바이스 기능을 수행