# Ubuntu18 에 Mysql DB 설치하기 (2)

## Ubuntu18 에 Mysql DB 설치하기 (2)

이번 포스팅에서는 mysql 계정을 생성하고 권한 부여하기, 그리고 기본 설정을 적용하여 보겠습니다.

**3 ) mysql user 생성 및 권한**

```
sudo mysql
```

mysql 실행

![https://blog.kakaocdn.net/dn/bhYu8J/btrqN4iv7C9/gppxK9oU0MJ1YqGRgpFNek/img.png](https://blog.kakaocdn.net/dn/bhYu8J/btrqN4iv7C9/gppxK9oU0MJ1YqGRgpFNek/img.png)

mysql 커맨드 창이 열립니다

```
SELECT user,authentication_string,plugin,host FROM mysql.user;
```

![https://blog.kakaocdn.net/dn/7X5q1/btrqNeTIckX/EpcGm0ivPRZ6U3L2MugUIk/img.png](https://blog.kakaocdn.net/dn/7X5q1/btrqNeTIckX/EpcGm0ivPRZ6U3L2MugUIk/img.png)

mysql user 테이블의 유저 권한, plugin, host 등 출력

mysql 5.7 이후 버전에서는 default 로 root 계정은  auth_socket 플러그인  을 사용하여 접속하게 되어있습니다.

이부분을 mysql _native_password 패스워드를 입력하여 root에 접근할 수 있게 변경해주어 보안을 강화할 수 있습니다.

```
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin1234';
```

root 유저가 localhost 에서 접근할때 admin1234 라는 패스워드로 접속하게 변경합니다.

```
FLUSH PRIVILEGES;
```

권한을 reload 해줍니다.

(이 때 이전에 설정한 비밀번호 정책과 맞지 않을 경우 에러 발생 )

![https://blog.kakaocdn.net/dn/cVZ8CD/btrqVvfv5Ol/CbYxJmKkOkK0xo9MAwCKH0/img.png](https://blog.kakaocdn.net/dn/cVZ8CD/btrqVvfv5Ol/CbYxJmKkOkK0xo9MAwCKH0/img.png)

mysql_native_password 로 plugin 이 변경된 것을 확인할 수 있습니다.

```
exit;
```

mysql 을 종료한후

```
sudo mysql -u root -p
```

root 계정에 password를 사용해 접속합니다.

패스워드 입력창이 나오면, 위에서 설정해준 패스워드를 입력하면 mysql 을 실행 할 수 있습니다.

이러한 형식으로 계정을 생성하고, 접근권한을 부여해 mysql 보안을 설정 할 수 있습니다.

## 

## **4 ) mysql 현재 시간 변경**

mysql 을 설치하고 사용하는 경우 대체고 now() 를 사용하여 현재 시간을 입력하는 경우가 있었는데, 이럴 경우 DB 의 시간은 UTC인데 실제 시간은 KTC로 사용하여야 하는 경우가 있습니다.

```
date
```

현재 설정된 시간대를 확인

```
 ls /usr/share/zoneinfo/Asia
```

Seoul 시간 대를 파일을 확인합니다.

```
sudo ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

localtime 에 대한 심볼릭 링크를 재설정합니다.

```
date
```

현재 시간대를 확인하면

![https://blog.kakaocdn.net/dn/oVzKx/btrqNgjQaCl/EyU3oBjItXYnTmIKPoM5FK/img.png](https://blog.kakaocdn.net/dn/oVzKx/btrqNgjQaCl/EyU3oBjItXYnTmIKPoM5FK/img.png)

KST로 바뀐것을 확인 할 수 있습니다.

```
mysql -u root -p				// mysql 실행
								// 패스워드입력
```

DB에 접속하여 현재 시간과 timezone 을 출력하면,

![https://blog.kakaocdn.net/dn/cb83fg/btrq2336lDT/FYlrfOHrUI7GBptDmN5Qtk/img.png](https://blog.kakaocdn.net/dn/cb83fg/btrq2336lDT/FYlrfOHrUI7GBptDmN5Qtk/img.png)

KST로 설정되어있는것을 확인 할 수 있습니다.

**5 ) mysql 외부 접속 허용**

```
sudo netstat -ntlp | grep mysqld
```

mysql localAddress와 Foreign Address를 확인합니다.

![https://blog.kakaocdn.net/dn/Frqbh/btrq0uBAMqf/cXFkABtgSCEBAB3bk5FMUK/img.png](https://blog.kakaocdn.net/dn/Frqbh/btrq0uBAMqf/cXFkABtgSCEBAB3bk5FMUK/img.png)

3306포트가 로컬 ip로 연결되어있는데,

mysql 을 외부에서 접속허용 또는 특정 ip에서만 접속하게 해주기 위하여 localAddress를 대역으로 변경해주어야 합니다.

mysql 설정파일을 변경하겠습니다.

```
sudo vi /etc/mysql/mysql.conf.d/mysqld.cnf
```

mysql 설정파일을 실행

![https://blog.kakaocdn.net/dn/b5Xn5Q/btrqY9xHzcm/o9acA22bwhKSDB0J0ikKK0/img.png](https://blog.kakaocdn.net/dn/b5Xn5Q/btrqY9xHzcm/o9acA22bwhKSDB0J0ikKK0/img.png)

약 40번째 행의 **bind-address** 를

모든 ip 일경우 0.0.0.0

혹은 특정 ip 주소로 변경후 저장합니다.

```
service mysql restart					// mysql 재시작
```

설정파일 적용시키기 위해 mysql 를 재시작 합니다.

```
sudo netstat -ntlp | grep mysqld
```

다시 mysqld address를 확인하면,

![https://blog.kakaocdn.net/dn/zje7m/btrqXwmnx3x/t68xTgFyvKCBb7Qfvr3kyK/img.png](https://blog.kakaocdn.net/dn/zje7m/btrqXwmnx3x/t68xTgFyvKCBb7Qfvr3kyK/img.png)

대역으로 ip가 변경되어있습니다.

외부에서 접속하여 DB를 연결하여 작업할 수있습니다.

- 참고url

[https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04)

[
How To Install MySQL on Ubuntu 18.04 | DigitalOcean
MySQL is an open-source database management system, commonly installed as part of the popular LAMP (Linux, Apache, MySQL, PHP/Python/Perl) stack. It uses a relational database and SQL (Structured Query Language) to manage its data. This tutorial will
www.digitalocean.com](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04)