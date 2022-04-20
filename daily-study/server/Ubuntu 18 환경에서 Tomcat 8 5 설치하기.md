# Ubuntu 18 환경에서 Tomcat 8.5 설치하기

✅  Check List

- ****Ubuntu 18 - AWS EC2 인스턴스 사용****
- Tomcat 8.5 버전
    - 8.5 다운로드 링크
    
    [](https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.75/bin/apache-tomcat-8.5.75.tar.gz)
    
    - 이외 버전
    
    [Apache Tomcat®](https://tomcat.apache.org/)
    
- Java 8

1. Java 설치 
- tomcat 설치 전 java 설치

```bash
sudo apt update
// 패키지 리스트 업데이트 

sudo apt install openjdk-8-jdk openjdk-8-jre
// java 8 버전 설치 
```

- java 설치 확인하기

```bash
java -version
// java 설치 버전 확인

openjdk version "1.8.0_312"
OpenJDK Runtime Environment (build 1.8.0_312-8u312-b07-0ubuntu1~18.04-b07)
OpenJDK 64-Bit Server VM (build 25.312-b07, mixed mode)

-> 위와 같이 출력되면 설치 완료.
```

1. Tomcat 설치
- tar 파일 다운로드

```bash
cd /tmp
// tmp 폴더에 압축파일 다운로드

curl -O https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.75/bin/apache-tomcat-8.5.75.tar.gz
```

- 설정 경로 밑에 톰캣 설치

```bash
// sudo 권한으로 /opt/tomcat 경로에 폴더 생성

sudo tar xzvf apache-tomcat-8*tar.gz -C /opt/tomcat --strip-components=1
// tar 파일을 /opt/tomcat 경로에 압축해제

cd /opt/tomcat
// 설치 경로로 이동

ls -al
// 폴더 내부 리스트 출력하면 tomcat /bin /conf /webapps 등 설치 확인!
```

- **tomcat 설치 확인**
    - `http://{{서버 도메인 혹은 ip}}:8080`
    - 기본 포트인 8080 포트로 접속하면 톰캣 설치 확인
    - ec2 에서는 인바운드 규칙편집 → 8080 포트가 열려있어야 외부에서 확인 가능!
    
1. Tomcat 서비스 등록 ( 🖐️ 필수 아님 )
- systemctl 명령어를 사용해 톰캣을 작동할 수 있게 서비스 등록

```bash
sudo groupadd tomcat

sudo useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
// tomcat 유저 그룹 생성.

sudo chgrp -R tomcat /opt/tomcat

sudo chmod -R g+r conf
sudo chmod g+x conf

sudo chown -R tomcat webapps/ work/ temp/ logs/
// 권한 부여

sudo update-java-alternatives -l
// 자바 설정 경로 확인

java-1.8.0-openjdk-amd64       1081       /usr/lib/jvm/java-1.8.0-openjdk-amd64
// 출력

-> JAVA_HOME 환경변수 경로 확인 해당 경로 끝에 /jre 를 붙여 설정파일에 세팅합니다.

sudo vi /etc/systemd/system/tomcat.service
// vi 혹은 nano 명령어 사용 해서 해당 경로에 tomcat.service 파일 생성
```

- tomcat.service 설정파일

```bash
[Unit]
Description=Apache Tomcat Web Application Container
After=network.target

[Service]
Type=forking

Environment=JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre
Environment=CATALINA_PID=/opt/tomcat/temp/tomcat.pid
Environment=CATALINA_HOME=/opt/tomcat
Environment=CATALINA_BASE=/opt/tomcat
Environment='CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC'
Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'

ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh

User=tomcat
Group=tomcat
UMask=0007
RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target
```

❗ java 환경변수와 톰캣의 설치 경로가 위와 같다면 위의 내용을 복사 / 붙여넣기 하고 저장합니다.

( * 이때 환경변수 혹은 tomcat 설치 경로가 다르다면 반드시 수정해 주어야함.)

- 설정파일 적용

```bash
sudo systemctl daemon-reload
// daemon 재시작해 서비스 설정파일을 읽어줍니다.

sudo systemctl start tomcat		//시작

sudo systemctl status tomcat	// 상태

sudo systemctl restart tomcat	// 재시작

sudo systemctl stop tomcat		// 중지
```

👻  해당 명령어 입력시 설정파일의 경로대로 tomcat 이 /bin 경로 아래의 ./startup.sh 혹은 ./shutdown.sh 를 수행하게됩니다.