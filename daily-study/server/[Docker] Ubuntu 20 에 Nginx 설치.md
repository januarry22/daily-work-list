# [Docker] Ubuntu 20 에 Nginx 설치

## Ubuntu 필요한 패키지 설치

- 빈 운영체제라 패키지들을 설치해 주어야함
- VM 가상머신으로 리눅스 환경을 설치하는 것과 같다

```bash
apt-get update

apt-get install net-tools vim openssh-server
// Region : Asia 
// Timezon : Seoul

~root@[컨테이너ID]:/# date     // 날짜 출력 
Tue May  3 17:46:14 KST 2022

```

## SSH 접속 설정 하기

```bash
vi /etc/ssh/sshd_config

[ sshd_config 파일]
PermitRootLogin yes      // 주석해제후 변경

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