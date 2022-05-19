# [CI/CD] Jenkins 설치하기

- Jenkins Repository Key 파일 다운로드

```bash
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
```

- Jenkins 패키지 저장소 추가

```bash
sudo sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > \
    /etc/apt/sources.list.d/jenkins.list'
```

- java 설치 확인

```bash
java -version
```

- jenkins 설치

```bash
sudo apt-get update
sudo apt-get install jenkins
```

- 서비스 실행

```bash
sudo systemctl daemon-reload
sudo systemctl start jenkins
sudo systemctl status jenkins
```

- 설치완료

```bash
sudo vi /var/lib/jenkins/secrets/initialAdminPassword
```

  -  [http://[내 ip]:8080](http://54.180.90.61:8080/) 입력해서 젠킨스 접속 ( 기본 포트 8080 )

  - 초기화면에서 패스워드 입력

  - 권장 프러그인 다운로드 

![스크린샷 2022-05-19 오후 6.00.53.png](%5BCI%20CD%5D%20Jenkins%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%E1%84%92%E1%85%A1%E1%84%80%E1%85%B5%20da0b3ee24f8c46fd83eac927b313a6d5/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-19_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_6.00.53.png)

- Jenkins 설정 파일 경로
    
    ```bash
    sudo vi /etc/default/jenkins
    ```