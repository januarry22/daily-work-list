# Ubuntu18 에 Mysql DB 설치하기 (1)

더보기

## Ubuntu18 에 Mysql DB 설치하기 (1)

Ubuntu 18 에 Mysql 5.7 버전을 설치하고 초기 보안 설정을 해보겠습니다.

**1 ) Mysql 설치**

```
sudo apt update							// 패키지 업데이트
sudo apt install mysql-server			// mysql 설치
```

![https://blog.kakaocdn.net/dn/caAxDa/btrqNyDNoLK/AJ308YLPtZjuIpaTGh6DZK/img.png](https://blog.kakaocdn.net/dn/caAxDa/btrqNyDNoLK/AJ308YLPtZjuIpaTGh6DZK/img.png)

Y 입력후 다운로드

```
sudo mysqladmin -p -u root version
```

위 명령어를 입력한 후 패스워드 커맨드가 나타나면 초기 세팅된 보안이 없기 때문에 Enter를 입력하여줍니다.

![https://blog.kakaocdn.net/dn/cPxSJ6/btrqLYDvoIQ/Iysdx0Ru1zLV4OCKpZn5J1/img.png](https://blog.kakaocdn.net/dn/cPxSJ6/btrqLYDvoIQ/Iysdx0Ru1zLV4OCKpZn5J1/img.png)

설치된 버전을 확인하면

mysql 5.7.36 버전인 것을 확인할 수 있습니다.

**2 ) mysql 설정**

```
sudo mysql_secure_installation
```

기본적으로 mysql DB에 관한 보안 설정을 강화할수 있습니다. 위 명령어를 입력하면

> Securing the MySQL server deployment.
> 
- > 보안플러그인을 설치하시겠습니까? 라는 내용입니다. Y 입력

> There are three levels of password validation policy:
> 
- > mysql 보안 정책 단계 입니다. 테스트 DB 이므로 0 (LOW)단계로 설정하겠습니다.

0 (LOW) : 길이 8자 이상

1 (MEDIUM) : 길이 8자 이상, 숫자, 대소문자 혼합, 특수문자

2 (STRONG) : 길이 8자 이상, 숫자, 대소문자 혼합, 특수문자, dictionary file 사용

> Please set the password for root here.
> 

-> root 비밀번호를 설정해 줍니다. admin12 로 설정

> 
> 
- > root패스워드 강도 (25)
- > 그대로 사용할것인지 ? Y 입력

> By default, a MySQL installation has an anonymous user,
> 
- > Anonymous user를 삭제 할 것인가? Y 입력 (삭제)
- > 필요에 따라 Y | N

> 
> 
- > root 계정으로 외부원격에서 접속을 허용할 것인가? Y 입력 (허용)
- > 필요에 따라 Y | N

> By default, MySQL comes with a database named 'test' that
> 
- > test database를 삭제 할 것인가? Y 입력 (삭제)
- > 필요에 따라 Y | N

> Reloading the privilege tables will ensure that all changes
> 
- > privilege reload 할것인가? Y 입력 (삭제)
- > 위 설정중 하나라도 변경하였다면 Y를 입력해야합니다.

> Success.
> 

적용 성공