# Ubuntu18 에서 Docker 로 Tomcat 배포하기

## **Docker로 Tomcat 배포하기**

이번 포스트에서는 Docker 의 이미지를 이용하여 tomcat을 배포하겠습니다.

더보기

1 ) Docker 이미지 다운로드

```
docker pull tomcat:8.5
```

docker 에서 톰캣 8.5 버전으로 이미지를 다운로드 합니다.

```
 docker run -d -i -t --name tomcat8.5-ver -p 8087:8080 tomat:8.5

 docker run -d -i -t --name [컨테이너명] -p [호스트port]:[가동port] [도커에서제공한이미지]
```

다운로드한 이미지를 실행합니다.

- **d** : 백그라운드 실행
- **-name** : 톰캣 이미지 이름 설정
- **p** : 포트번호 설정, host에서 8087포트로 접속시 도커컨테이너의 8080으로 연결시켜준다

(기본적으로 tomcat은 8080포트에서 실행되기 때문에 8080으로 가동됨)

- 마지막 으로 도커에서 pull 받은 톰캣 이미지를 설정

```
docker ps -a
```

도커에서 실행중인 이미지들을 보여줍니다.

![https://blog.kakaocdn.net/dn/mxh6m/btrqVvVzhpq/Qp5jxrnboaUKqRi0IfTDKk/img.png](https://blog.kakaocdn.net/dn/mxh6m/btrqVvVzhpq/Qp5jxrnboaUKqRi0IfTDKk/img.png)

컨테이너 id    사용한 도커이미지                                                                  사용port 내역                                               컨테이너이름

2) war 파일 배포하기

```
 docker exec -it 89e6271c5a53 /bin/bash

 docker exec -it [컨테이너ID] /bin/bash
```

도커 컨테이너에 접속하여 내부를 확인해보면, 경로는 /usr/local/tomcat 이 기본적으로 세팅되고 톰캣을 다운로드 하였을때와 같이 webapps/ conf/ bin/ 파일 디렉토리가 생성 되어있는것을 확인 할 수 있습니다.

![https://blog.kakaocdn.net/dn/Gl4bH/btrq0SoFzxF/2SfbueDkzZB2PtT8q9Do21/img.png](https://blog.kakaocdn.net/dn/Gl4bH/btrq0SoFzxF/2SfbueDkzZB2PtT8q9Do21/img.png)

기존에 있던 프로젝트를 임의로 docker로 세팅한 톰캣에 배포하겠습니다.

```
 docker cp ROOT.war tomcat8.5-ver:/usr/local/tomcat/webapp
```

war파일을 도커로 복사합니다.

```
docker exec -it 89e6271c5a53 /bin/bash
```

다시 도커내부를 실행시켜보면 ROOT.war 파일이 배포되어 ROOT 폴더가 생성된것을 확인할 수 있습니다.

logs 폴더에서

```
tail -f catalina.out				 // 로그확인
```

![https://blog.kakaocdn.net/dn/bLpGau/btrqXws9bm6/0jRMx18O61vIvx9whSBN0k/img.png](https://blog.kakaocdn.net/dn/bLpGau/btrqXws9bm6/0jRMx18O61vIvx9whSBN0k/img.png)

8080포트를 이용하여 ROOT파일이 실행 한것을 확인 할 수 있습니다.