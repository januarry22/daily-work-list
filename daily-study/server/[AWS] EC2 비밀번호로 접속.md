# [AWS] EC2 비밀번호로 접속

## 기존 ec2 인스턴스 접속시

- pem 키 사용하여 ssh 로 접속
    
    ```bash
    ssh -i "[pem키] ubuntu@[인스턴스 주소].ap-northeast-2.compute.amazonaws.com
    ```
    

## 리눅스 계정 생성

### 계정 추가

```bash
sudo useradd [계정 ID]
// 리눅스 계정 추가 

sudo passwd [계정 ID]
// 패스워드 설정 
```

### ssh 설정 변경

```bash

sudo vi /etc/ssh/sshd_config
// ssh 설정 파일

PasswordAuthentication yes
// 패스워드로 인증가능하게 변경

sudo service sshd restart
// ssh 재시작
```

### 접속 디렉토리 생성

```bash
sudo mkdir /home/[계정 ID]
// 해당계정으로 디렉토리 생성 

sudo  chown -R our1: /home/our1
// 디렉토리권한 부여

```

<aside>
💡 ssh [계정]@[인스턴스 주소]

</aside>

- 패스워스 입력후 생성한 디렉토리로 접속됨 !