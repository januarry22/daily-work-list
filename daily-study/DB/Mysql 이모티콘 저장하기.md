# Mysql 이모티콘 저장하기

크롤링 작업중 상세 페이지 내용을 content 컬럼에 저장해야하는데, insert 하는 중 해당 에러 발생.

**Incorrect string value: '\xF0\x9F\x98\x8A</...' for column**

- 실제 쇼핑몰에서 크롤링한 데이터 이다 보니 수많은 이모티콘들이 포함 되어있었다.

**해결 :  DB 의 charaterset 을 변경해주어야 한다.**

> ○ utf8과 utf8mb4의 차이점?
> 

이모지와 같은 글자들은 글자당 최대 4bytes가 필요합니다

하지만 utf8은 글자당 최대 3bytes까지 지원하는 가변 자료형 입니다

따라서 가변 4bytes의 문자열을 저장할 수 있는 utf8mb4를 사용하면 이모지를 저장할 수 있습니다.

- Ubuntu 18 서버에 mysql 이 설치 되어 있었으므로,

```
cd /etc/mysql/mysql.conf.d			// 폴더로 이동
sudo vi mysqld.cnf 					// sudo 권한으로 실행
```

해당경로로 들어가 mysql설정파일을 편집해야한다.

(설정파일 변경전 cp 명령어를 사용해 백업파일을 생성하여야함!)

```
[client]
default-character-set = utf8mb4

[mysql]
default-character-set = utf8mb4

[mysqld]
character-set-client-handshake = FALSE
character-set-server = utf8mb4
collation-server = utf8mb4_unicode_ci
```

해당 내용을 각각 추가해 주고

```
sudo service mysql restart
```

mysql 재시작 하였을때 커맨드 창이 떨어지면 , 설정파일에 오류가 없이 적용된것.

- 로컬에 연결된 sql 툴이나 서버에서 mysql 을 실행하여

```sql
SHOW GLOBAL VARIABLES WHERE Variable_name LIKE 'character\_set\_%' OR Variable_name LIKE 'collation%'
```

쿼리 실행 !

![https://blog.kakaocdn.net/dn/8m59m/btrqujfudQ2/Fl0NUEFsABXdk2T4sKiel1/img.png](https://blog.kakaocdn.net/dn/8m59m/btrqujfudQ2/Fl0NUEFsABXdk2T4sKiel1/img.png)

위 그림과 같이 character_set 이 변경되어있다.

```sql
ALTER DATABASE [데이터베이스 이름] CHARACTER SET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

기존의 DB 에도 해당 쿼리를 실행해 변경해준다.

이후 다시 insert 하게 되면 에러 없이 쿼리가 실행된다.

- 참고 url

[https://artiiicy.tistory.com/31](https://artiiicy.tistory.com/31)