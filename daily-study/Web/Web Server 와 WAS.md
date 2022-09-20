# Web Server 와 WAS

![https://blog.kakaocdn.net/dn/d8HLu8/btrqyta6AkO/BNfwXWwkUqTE5vx2LvKvWk/img.png](https://blog.kakaocdn.net/dn/d8HLu8/btrqyta6AkO/BNfwXWwkUqTE5vx2LvKvWk/img.png)

> 정적 페이지와 동적페이지
> 

1) 정적 페이지

정적 페이지는 url 을 통해 들어오는 요청들을 만들어진 그대로 나타내는 정적 웹페이지를 말한다.

웹 서버 만으로도 구동이 가능하며 응답 속도가 빠르다.

2) 동적 페이지

동적 페이지는 각각의 요청들에 대해 각각 다른 응답들을 반환하여 나타내준다.

사용자(클라이언트)의 요청에 따라 응답이 달라지기 때문에 응답 속도가 느리고, 각각의 요청별로 생성된 html을 사용자에게 반환하는데 이것을 동적 웹페이지 라고한다.

> Web Server 와 WAS (Web Application Server)
> 

![https://blog.kakaocdn.net/dn/KI6Uh/btrqui2JTsT/H8cQNYlVlw0WwYQhZJk0F1/img.png](https://blog.kakaocdn.net/dn/KI6Uh/btrqui2JTsT/H8cQNYlVlw0WwYQhZJk0F1/img.png)

1) Web Server

웹 브라우저와 같은 클라이언트로 부터 HTTP 요청을 받아 정적인 컨텐츠를 제공하는 서비스이다.여기서 정적인 컨텐츠란 html, js, css,이미지 등 웹페이지의 뼈대를 이루고 있는 즉시 응답가능한 컨텐츠이다.

대표적인 web server 로는 apache , nginx 등이 있다.

2) WAS

WAS 란 Web Application Server 의 약자로, 동적 컨텐츠를 제공하기 위해 만들어진 애플리케이션 서버로써 웹 프로그램을 실행할 수 있는 환경을 제공한다.

웹서버와 웹 컨테이너가 합쳐진 형태로, 웹서버에서 처리할 수 없는 동적인 요청들을 처리한다.

예를들어, 포털 검색 사이트에 접속하였을때 클라이언트의 요청을 받은 웹서버는 먼저 정적인 컨텐츠들을 응답한다. 웹서버에서는 즉시 응답가능한 컨텐츠만이 노출되어 있고, 검색 서비스를 위한 데이터는 웹 컨테이너에 구성되어있기 때문에 클라이언트가 검색을 하기위해 검색어를 입력하고 버튼을 누르면 웹서버는 이 요청을 받아 WAS로 넘기게된다. WAS는 이요청을 받아 검색어와 DB를 비교하거나, 내부적인 로직을 수행하여 응답을 구성하고 웹서버로 다시 결과를 보내게 된다.

대표적으로 Tomcat이 있다.

> Web Server 와 WAS를 분리하는 이유?
> 
- 물리적 으로 분리하여 보안을 강화
- 자원의 효율적 이용 및 부하 방지
- 분산 처리 용이
- 참고 url : [https://velog.io/@change/WEB%EC%84%9C%EB%B2%84-WAS-%EB%B6%84%EB%A6%AC-%EC%9D%B4%EC%9C%A0](https://velog.io/@change/WEB%EC%84%9C%EB%B2%84-WAS-%EB%B6%84%EB%A6%AC-%EC%9D%B4%EC%9C%A0)