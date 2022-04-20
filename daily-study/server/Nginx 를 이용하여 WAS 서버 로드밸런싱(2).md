# Nginx 를 이용하여 WAS 서버 로드밸런싱(2)

### **Nginx 를 이용하여 WAS 서버 로드밸런싱(2)**

더보기

저번 포스팅에 이어 리눅스 환경에서 nginx 와 톰캣을 이용해 WAS를 로드밸런싱 해보겠습니다.

1 ) WAS 세팅

먼저 리눅스에 각각 2대의 톰캣을 설치하여 8080번 포트와 8083포트를 이용하도록 설정을 변경해두었습니다.

8080 -> tomcat1

8083 -> tomcat2

```
http://[서버ip]:8080/

http://[서버ip]:8083/
```

톰캣이 잘 실행 되는 것을 확인한뒤 tomcat2 의 appBase를 tomcat1 의 리소스와 공유하게 설정을 변경하도록 하겠습니다.

![https://blog.kakaocdn.net/dn/rsoEc/btrrku75HVO/Y8CUAyMkNfGHdZKRWqh0S0/img.png](https://blog.kakaocdn.net/dn/rsoEc/btrrku75HVO/Y8CUAyMkNfGHdZKRWqh0S0/img.png)

그림과 같이 tomcat2/conf server.xml 파일의 152번째 행에 appBase를 tomcat1 의 리소스 경로로 변경하여 줍니다.

이렇게 함으로써 하나의 리소스를 총 2대의 WAS가 공유하고 있게 됩니다.

```
:wq									// 저장
/home/cron/tomcat2/bin/shutdown.sh	// 톰캣 중지
/home/cron/tomcat2/bin/startup.sh	// 톰캣 시작
```

![https://blog.kakaocdn.net/dn/bpXdpd/btrrPgPMzwh/AxgjJk2LbqORj1pKcNnkqK/img.png](https://blog.kakaocdn.net/dn/bpXdpd/btrrPgPMzwh/AxgjJk2LbqORj1pKcNnkqK/img.png)

8080 포트 연결한 tomcat1

![https://blog.kakaocdn.net/dn/bgjD08/btrrPPK542o/bNp5vRMI1V5dbk5JkTXxf0/img.png](https://blog.kakaocdn.net/dn/bgjD08/btrrPPK542o/bNp5vRMI1V5dbk5JkTXxf0/img.png)

8083 포트 연결한 tomcat2

tomcat1 의 index.jsp 내용을 바꿔준 후 확인해보면 위 그림처럼 같은 리소스가 나타납니다.

2 ) Nginx 설치

```
sudo apt update
sudo apt install nginx
```

![https://blog.kakaocdn.net/dn/EyOAL/btrrKxExNzT/Cn37T81b0WL90nBOThL8l0/img.png](https://blog.kakaocdn.net/dn/EyOAL/btrrKxExNzT/Cn37T81b0WL90nBOThL8l0/img.png)

웹서버의 경우 default로 80 포트를 사용하기때문에 ip 주소를 입력해주면 nginx가 설치 된 것을 확인 할 수 있습니다.

```
netstat -nltp					// 80포트 사용중 인것 확인
```

또는 위 명령어를 실행해서 80포트가 사용되는 것을 알 수 있습니다.

```
cd /etc/nginx/sites-available
ls -al
```

위 경로로 들어가면 (ubuntu18기준) default 파일이 있는 것을 확인 할 수 있습니다.

```
sudo vi default
```

![https://blog.kakaocdn.net/dn/oJu33/btrrP3Jb7AH/m93JPsYnFLC06J0Vr41AQ1/img.png](https://blog.kakaocdn.net/dn/oJu33/btrrP3Jb7AH/m93JPsYnFLC06J0Vr41AQ1/img.png)

설정 파일을 열어서 변경해주도록하겠습니다.

```
upstream tomcatbalance {
    server localhost:8080;
    server localhost:8083;
}

// tomcatbalance 그룹으로 웹서버 가동 8080 포트와 8083사용
// ip주소를 이용해 로드밸런싱 할 경우 별도로 부가 설정들이 필요함.
```

```
   location / {
                # First attempt to serve request as file, then
                # as directory, then fall back to displaying a 404.
                #try_files $uri $uri/ =404;
                proxy_pass http://tomcatbalance;

        }

 // tomcatbalance 로 웹서버 접속
```

위와 같이 설정파일 내용들을 추가하여줍니다.

```
 <!-- 해당 내용들은 주석처리 -->
 root /var/www/html

 try_files $uri $uri/ =404;
```

위의 내용들은 주석처리해주세요.

저장한 뒤 빠져 나옵니다.

```
sudo service nginx restart					// nginx 재시작
```

설정파일을 적용하기 위해 웹서버를 재시작 합니다.

![https://blog.kakaocdn.net/dn/utm4W/btrrLNtPMxw/av5lAPmb6qwQcPcHH1LKwK/img.png](https://blog.kakaocdn.net/dn/utm4W/btrrLNtPMxw/av5lAPmb6qwQcPcHH1LKwK/img.png)

WAS로 요청을 보내게 되면 일정 비율로 tomcat1으로 접속하다 tomcat2로 옮겨 가는 것을 확인 할 수 있습니다.

또는 WAS 1대를 종료하여도 나머지 1대를 이용해서 계속 요청을 수행 할 수 있습니다.