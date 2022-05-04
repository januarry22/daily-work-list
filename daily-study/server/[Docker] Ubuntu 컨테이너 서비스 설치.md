# [Docker] Ubuntu 컨테이너 서비스 설치

## Ubuntu 필요한 패키지 설치

- 빈 운영체제라 패키지들을 설치해 주어야함
- VM 가상머신으로 리눅스 환경을 설치하는 것과 같다

```bash
apt-get update

apt-get install net-tools vim openssh-server
// Region : 6.Asia 
// Timezon : 69.Seoul

~root@[컨테이너ID]:/# date     // 날짜 출력 
Tue May  3 17:46:14 KST 2022

```

## SSH 접속 설정 하기

```bash
vi /etc/ssh/sshd_config

[ sshd_config 파일]
PermitRootLogin yes      // 주석해제후 변경 - 34번째 줄

:wq                      // 저장 후 나가기 
```

```bash
passwd root              // root 패스워드 변경

New password: 
Retype new password: 
passwd: password updated successfully
```

```bash
service ssh start        // ssh 실행

* Starting OpenBSD Secure Shell server sshd
```

- 다른 터미널 창 접속

```bash
ssh root@127.0.0.1 -p 2000 
// host 2000번 포트로 컨테이너 22번 연결해두었기때문에 2000이용해서 접속

root@localhost's password:
// 패스워드 입력
```

![스크린샷 2022-05-04 오전 9.46.40.png](%5BDocker%5D%20Ubuntu%20%E1%84%8F%E1%85%A5%E1%86%AB%E1%84%90%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%82%E1%85%A5%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%B5%E1%84%89%E1%85%B3%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%2018da588af00242dcac1ed48cb2ea2ec9/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-04_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_9.46.40.png)

- SSH 로 리눅스에 접근 할 수 있게됨

## Nginx 설치

```bash
apt update
apt upgrade

apt install nginx
// nginx 설치 

root@[컨테이너ID]:/# nginx -v 
nginx version: nginx/1.18.0 (Ubuntu)
// 설치 확인

root@[컨테이너ID]:/# service nginx start
 * Starting nginx nginx
// nginx 실행
```

## 실행 중인 서비스 확인

```bash
service --status-all

 [ - ]  dbus
 [ ? ]  hwclock.sh
 [ + ]  nginx
 [ - ]  procps
 [ + ]  ssh

// ssh 와 nginx 가 실행중인 것을 확인 할 수 있다.

netstat -nltp
// 실행중인 포트 확인 80 포트와 22 포트 실행중 

Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name    
tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      936/sshd: /usr/sbin 
tcp        0      0 0.0.0.0:80              0.0.0.0:*               LISTEN      878/nginx: master p 
tcp6       0      0 :::22                   :::*                    LISTEN      936/sshd: /usr/sbin 
tcp6       0      0 :::80                   :::*                    LISTEN      878/nginx: master p
```

- nginx 설정파일 변경 필요시

```bash
find / -name nginx.conf
// nginx 설정 파일 찾기

/etc/nginx/sites-available/default

```

- 도커 컨테이너 상세 정보 확인

```bash
docker inspect [컨테이너 ID]
// 도커 컨테이너 상세 정보 확인
// 네트워크, ip, 컨테이너 정보 출력
```