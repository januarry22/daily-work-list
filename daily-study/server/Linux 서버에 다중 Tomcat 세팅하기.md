# Linux 서버에 다중 Tomcat 세팅하기

리눅스 환경을 사용하다보면 하나의 서버에 여러개의 WAS를 세팅해서 사용하는 경우가 빈번하게 발생하였다.

예를들면, api 서버와 admin 서버 혹은 push 서버 등 각기 다른 역할을 수행 하는 WAS를 하나의 자원으로 관리 할 수 없기 때문이다.

더보기

> 디렉토리 구성은 이러하다.
> 

/home/cron/톰캣설치파일    - >  이론적으로 쉽게 이해하기 위해 해당 경로에 톰캣파일을 설치하겠습니다.

/home/cron/tomcat1          - >  첫번째 tomcat 으로 8080 포트로 연결

/home/cron/tomcat2          - >  두번째 tomcat 으로 8083 포트로 연결

1 ) 톰캣 설치 및 디렉토리 생성

```
curl -O https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.73/bin/apache-tomcat-8.5.73.tar.gz
```

![https://blog.kakaocdn.net/dn/nzxrf/btrqFjm6E2l/zqHHqZzIwohKXNHGDOs6Dk/img.png](https://blog.kakaocdn.net/dn/nzxrf/btrqFjm6E2l/zqHHqZzIwohKXNHGDOs6Dk/img.png)

8.5 버전으로 다운로드 완료 되었습니다.

```
sudo tar xzvf apache-tomcat-8*tar.gz
```

tar.gz 파일을 압축 해제 합니다.

```
mv apache-tomcat-8.5.73 tomcat1
```

압축해제후 생성된 tomcat 파일 디렉토리명을 tomcat1 로 변경합니다.

```
cp -r tomcat1/ tomcat2
```

아직 세팅하기전의 톰캣이기 때문에 동일하게 복사해서 tomcat2로 된 톰캣 디렉토리를 생성합니다.

- 이 글에서는 압축해제한 톰캣 디렉토리를 복사해서 같은 디렉토리를 만들었는데, mkdir 명령어로 tomcat1, tomcat2 디렉토리를 먼저 생성하고 tar.gz파일을 해당 디렉토리 아래에 압축해제 하는등 편한 방법을 이용하면 됩니다.

```
ls -al			// 해당 디렉토리의 폴더, 파일 표시
```

![https://blog.kakaocdn.net/dn/bBrIkq/btrqGUtjtsC/T1ttKuHWKkTcSCpSBy8w2k/img.png](https://blog.kakaocdn.net/dn/bBrIkq/btrqGUtjtsC/T1ttKuHWKkTcSCpSBy8w2k/img.png)

위 처럼 톰캣 2개 생성이 완료되었습니다.

2 ) 톰캣 설정파일 ( server.xml) 변경

먼저 , 사용중인 포트 번호를 확인하여 해당 포트들은 피해서 설정을 바꾸어 주도록 하겠습니다.

```
netstat -nltp
```

**첫번째로 tomcat1의 설정파일은 8080 포트를 사용할 것이기 때문에 초기 세팅 그대로 두도록합니다.**

```
sudo vi /home/cron/tomcat1/conf/server.xml
```

해당 경로로 가서 설정파일을 열어보면,

![https://blog.kakaocdn.net/dn/HXCPc/btrqCTvqLZI/0mNkcaKPlkrmHlQzRGnSx1/img.png](https://blog.kakaocdn.net/dn/HXCPc/btrqCTvqLZI/0mNkcaKPlkrmHlQzRGnSx1/img.png)

보기 편하게 하기 위해서

:set nu

69번째 행 정도에 <Connector port="8080"/>  태그안에 port가 바로 톰캣을 실행할 포트번호가 됩니다.

한개의 물리서버내에서 여러개의 톰캣을 실행할 때 이 포트넘버는 절대 중복되어선 안됩니다.

![https://blog.kakaocdn.net/dn/sRaoQ/btrqHEcHS3q/rXG4CkJu7e45eTK9CN9Hfk/img.png](https://blog.kakaocdn.net/dn/sRaoQ/btrqHEcHS3q/rXG4CkJu7e45eTK9CN9Hfk/img.png)

22 번째 행 정도에 <Server port="8005"/>

shutdown 포트번호입니다. 이 포트 번호가 중복될 시에는 ./shutdown.sh 실행시 같은 포트번호를 가진 톰캣들이 모두 종료처리 될 수 있으므로 두번째 톰캣부터는 해당 포트번호도 변경하여 줍니다.

- 추가로 117번째 행 정도에 이 AJP 포트는 톰캣단독 사용시에는 사용되지 않지만, web 서버와 연동하여 사용할 때에는 해당 포트 번호도 변경하여 사용합니다.

![https://blog.kakaocdn.net/dn/bsvgvF/btrqCTI1npH/K344OWTGE4kR6GarpV5cMK/img.png](https://blog.kakaocdn.net/dn/bsvgvF/btrqCTI1npH/K344OWTGE4kR6GarpV5cMK/img.png)

- 각각의 설정파일이 어려울 때에는 구글링을 해서 설정파일에서 변경되는 부분이 하는 역할을 이해하고 변경하여 본뒤에, 설정파일을 열어 주석처리된 부분을 읽으면 이해하는데 도움이 됩니다.

**두번째로 tomcat2 톰캣의 server.xml 은 위와같이 해당하는 태그들의 포트넘버를 각각 변경하겠습니다.**

```
sudo vi /home/cron/tomcat2/conf/server.xml
```

설정파일을 열어,

실행포트는 8083 번 포트를 이용할 것이기 때문에, Connector port = "8083" 으로 변경하겠습니다.

![https://blog.kakaocdn.net/dn/bvaFqW/btrqBH26LtL/SKHk6OuxxVTbX083vSWxj0/img.png](https://blog.kakaocdn.net/dn/bvaFqW/btrqBH26LtL/SKHk6OuxxVTbX083vSWxj0/img.png)

shutdown 포트는 8305 로 변경하겠습니다.

![https://blog.kakaocdn.net/dn/blLkwt/btrqBHa04v3/gmKeUgtphUH9MJmTpomlO1/img.png](https://blog.kakaocdn.net/dn/blLkwt/btrqBHa04v3/gmKeUgtphUH9MJmTpomlO1/img.png)

변경후 :wq

3 ) 다중 톰캣 실행

설정파일 변경이 완료 되었으면 두개의 톰캣을 실행시켜 잘 작동하는지 확인합니다.

```
/home/cron/tomcat1/bin/startup.sh 			// 1번 tomcat

/home/cron/tomcat2/bin/startup.sh 			// 2번 tomcat
```

각각 url 창에 포트번호를 붙여 ip 주소를 입력하여 접속합니다.

( 이글에서 aws ec2 를 사용하였으므로 인스턴스의 인바운드 규칙에서 8080과 8083 포트를 모두 열어주었습니다.)

```
http://서버ip주소:8080/

http://서버ip주소:8083/
```

두가지 모두 톰캣 매니저가 나타나지만 명확하게 구분하기 위해 임시로 프로젝트 하나를 tomcat1 에 배포해 주었습니다.

- 프로젝트가 없을경우 하나의 톰캣에 /webapps/ROOT/index.jsp 파일의 내용을 살짝 변경하여줍니다.
- 배포 완료된 tomcat1

![https://blog.kakaocdn.net/dn/6AL26/btrqIrYviWu/sS17V8IPa5I9QAOKXjJ59k/img.png](https://blog.kakaocdn.net/dn/6AL26/btrqIrYviWu/sS17V8IPa5I9QAOKXjJ59k/img.png)

- tomcat2

![https://blog.kakaocdn.net/dn/BheQp/btrqIrqFzy2/oS9aOMKEi4cYvduKB5f6LK/img.png](https://blog.kakaocdn.net/dn/BheQp/btrqIrqFzy2/oS9aOMKEi4cYvduKB5f6LK/img.png)

이 처럼 포트 설정을 변경하여  톰캣의 수를 늘려갈 수 있습니다.

도메인을 추가하여 관리하거나, WAS를 로드밸런싱 하기 위해서는 Web Server (apache, Nginx 등) 을 붙여서 관리하여 줄 수있습니다.