# [Web] - REST API

```html
1. REST API 의 개념
	- REST의 개념과 특징
2. REST API의 작동 방식
3. REST API의 설계
4. Spring 에서의 RestAPI
```

## 1. REST API 란?

- **Representational State Transfer(REST)의 약자로, API 작동 방식에 대한 조건(REST방식)을 부과하는 소프트웨어 아키텍처**
- 기본적으로 웹의 기본 기술과 HTTP프로토콜의 장점을 극대화 하여 활용
- REST 기반의 아키텍처를 사용하여 대규모 고성능 통신을 안정적으로 지원
- 쉽게 구현하고 수정할 수 있어 여러 플랫폼에서 사용 가능

```html
❗ API(Application Programming Interface)란?
데이터와 기능의 집합을 제공하여 컴퓨터 프로그램간 상호작용을 촉진하며, 서로 정보를 교환가능 하도록 하는 것
```

### REST 의 개념

```html
**자원(resource)**의 **표현(representation)**에 의한 **상태(정보)**를 전달
문서, 데이터 등      어떤 자원에 대한 명시       데이터가 요청되어      
소프트웨어가 관리하는                         지는 시점의 자원의 상태
모든것을 의미                               주로 JSON, XML통해 주고받음

❗ **HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, 
HTTP Method(POST, GET, PUT, DELETE)를 통해 
해당 자원에 대한 CRUD Operation을 적용하는 것을 의미한다.**
```

- **REST의 CRUD Operation**
    - Create : 생성(POST)
    - Read : 조회(GET)
    - Update : 수정(PUT)
    - Delete : 삭제(DELETE)
    - HEAD: header 정보 조회(HEAD)
- **REST의 구성요소**
    - **자원(Resource) : HTTP URI**
        
        모든 자원에 고유한 ID가 존재하고, 이 자원은 Serve에 존재
        
    - **자원에 대한 행위(Verb) : HTTP Method**
        
        HTTP프로토콜 메소드 (POST, GET, PUT, DELETE)를 사용
        
    - **자원에 대한 행위의 내용 (Representations) : HTTP Message Pay Load**
        
        Client가 자원의 상태에 대한 조작을 요청하면 Server는 이에 대한 적절한응답(Representations) 보냄
        
        JSON 혹은 XML을 통해 주고받음
        
- **REST의 특징**
    - Server-Client(서버-클라이언트)구조
        
        자원을 요청하는 쪽이 Client, 자원이 있는 쪽이 Server
        
        서로간의 의존성이 줄어듬
        
    - Stateless(무상태)
        
        Server는 각각의 요청을 별개의 것(임의의 순서)으로 인식하고 처리함
        
        HTTP Session과 같은 컨텍스트 저장소에 상태 정보 저장 하지않으므로 구현이 단순해짐
        
    - Cacheable(캐시 가능성)
        
        서버 응답 시간을 개선하기 위해 캐싱을 지원
        
        캐시 사용을 통해 응답시간 단축, REST Server 트랜잭션이 발생하지 않아 전체 응답시간, 성능, 서버자원의 이용률을 향상시킴
        
    - Layered System(계층화)
        
        계층화된 시스템 아키텍처에서 Client-Server사이의 다른 중계층 연결가능
        
        Client는 REST Server API를 호출하고, Server는 보안, 로드밸런싱, 암호화, 사용자 인증 등 다중 계층으로 구성하여 확장성과 보안성 향상
        
    - Code-On-Demand(optional)
        
        Server로부터 프로그래밍 코드(스크립트)를 Client에 전송하여 Client기능을 일시적으로 확장하거나 사용
        
    - Uniform Interface(인터페이스 일관성)
        
        균일한 인터페이스를 통해 Server가 표준 형식으로 정보를 전송함을 나타냄
        
        HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능
        
- **REST의 장점**
    - 확장성
        
        REST API를 구현하는 시스템은 REST가 클라이언트-서버 상호 작용을 최적화하기 때문에 효율적으로 크기 조정할 수 있고, HTTP 프로토콜의 인프라를 그대로 사용하므로 REST API 사용을 위한 별도의 인프라를 구축할 필요가 없음
        
    - 유연성
        
        완전한 클라이언트-서버 분리 구조이기 때문에 서버 애플리케이션의 플랫폼,기술이 변경되어도 클라이언트 애플리케이션에 영향을 미치지 않음.
        
        HTTP 표준 프로토콜을 사용하는 모든 플랫폼에서 사용가능
        
    - 독립성
        
        사용되는 기술과 독립적이기 때문에 API설계에 영향을 주지 않고 다양한 프로그래밍 언어로 클라이언트 및 애플리케이션을 모두 작성할 수 있음
        
- **REST의 단점**
    - 표준 자체가 존재하지 않아 정의가 필요
    - HTTP Method 형태가 제한적
    - 구형브라우저에서의 호환 문제

## 2. REST API 작동방식

1. **클라이언트가 서버에 요청을 전송.** 클라이언트가 API 문서에 따라 서버가 이해하는 방식으로 요청 형식을 지정
2. 서버가 클라이언트를 인증하고 해당 요청을 수행할 수 있는 **권한이 클라이언트에 있는지 확인**
3. **서버가 요청을 수신하고 내부적으로 처리**
4. **서버가 클라이언트에 응답을 반환**. 응답에는 요청이 성공했는지 여부를 클라이언트에 알려주는 정보와 클라이언트가 요청한 모든 정보가 포함 

```html
✔️ **REST API 클라이언트 요청에 포함 되는 것
	
- 고유 리소스 식별자**
서버는 고유한 리소스 식별자로 각 리소스를 식별.
REST서버는 일반적으로 URL(Uniform Resource Locator)을 사용하여 리소스 식별을 수행함. 
URL은 리소스에 대한 경로를 지정하고요청 엔드포인트라고도 하며 클라이언트가 요구하는 사항을 
서버에 명확하게 지정함

- **메서드(Method)**
GET / POST / PUT / DELETE

- **HTTP 헤더**
요청 헤더는 클라이언트와 서버 간에 교환되는 메타데이터로
요청 및 응답의 형식을 나타내고 요청 상태 등에 대한 정보를 제공

- **데이터**
REST API 요청에는 POST, PUT 및 기타 HTTP 메서드가 성공적으로 작동하기 위한 데이터가 포함될 수 있음

- **파라미터**
URL 세부정보를 지정하는 경로 파라미터.리소스에 대한 추가 정보를 요청하는 쿼리 파라미터.
클라이언트를 빠르게 인증하는 쿠키 파라미터. 등이 포함 될 수 있음
```

## 3. REST API 의 설계

- URI는 정보의 자원을 표현
- 자원에 대한 행위는 HTTP Method로 표현

### REST API 설계 규칙

- **슬래시 구분자(/ )는 계층 관계를 나타내는데 사용한다.**

```html
https://**{{domain}}**/houses/apartments
```

- **URI 마지막 문자로 슬래시(/ )를 포함하지 않는다.**
URI에 포함되는 모든 글자는 리소스의 유일한 식별자로 사용되어야 하며 URI가 다르다는 것은 리소스가 다르다는 것을 의미함. REST API는 분명한 URI를 만들어 통신을 해야 하기 때문에 혼동을 주지 않도록 URI 경로의 마지막에는 슬래시(/)를 사용하지 않는다.

```html
https://**{{domain}}**/houses/apartments/ -> (x)
```

- **언더바(_ )대신 하이픈(- )은 URI 가독성을 높이는데 사용**
밑줄은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 하므로 불가피하게 긴 URI경로를 사용하게 된다면 하이픈을 사용해 가독성을 높인다.

```html
https://**{{domain}}**/houses/apartments-relation
```

- **URI 경로에는 동사보다는 명사를, 대문자보다는 소문자를 사용**
RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정하기 때문에URI 경로에 대문자 사용은 피하도록 한다.
- **파일확장자는 URI에 포함하지 않는다.**
REST API에서는 메시지 바디 내용의 포맷을 나타내기 위한 파일 확장자를 URI 안에 포함시키지 않는다.

```html
https://**{{domain}}**/houses/apartments/[photo.jpg](http://restapi.example.com/members/soccer/345/photo.jpg) -> (x)
```

- **리소스 간에는 연관 관계가 있는 경우**
/리소스명/리소스 ID/관계가 있는 다른 리소스명

```html
https://**{{domain}}**/houses/apartments/{apartID}/part
```

### RESTful 이란?

RESTful은 일반적으로 REST라는 아키텍처를 구현하는 웹 서비스를 나타내기 위해 사용되는 용어

REST의 원리를 따르는 시스템을 RESTful 하다고 표현 할 수 있음.

❗ RESTful 하지 못한 경우
     CRUD 기능을 모두 POST로만 처리하는 API
     URI 에 resource, id 외의 정보가 들어가는 경우 등

## 4. Spring 에서의 RestAPI

- @RestController 어노테이션 사용

```java
// 기존 @Controller 와 @ResponseBody 를 사용하여 api 데이터(json) 리턴
@Controller
public class BannerRestController {

   @ResponseBody // 응답값 그대로 반환하기 위해 사용
   @RequestMapping(value = "/api/v1/banner", method = RequestMethod.GET)
   public ApiResponse bannerList(HttpServletRequest httpRequest) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        apiRes.setAlert(true);
        apiRes.setData(bannerService.bannerList());
        apiRes.setSuccess(true);
        return apiRes;
    }

}

// @RestController로 @ResponseBody사용하지 않고도 api 데이터 리턴
@RestController
@RequestMapping("/api/v1/banner")
public class BannerRestController {

    @Autowired
    BannerService bannerService;

    @GetMapping("/list")
    @ApiOperation(value = "배너 리스트")
    public ApiResponse bannerList(HttpServletRequest httpRequest) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        apiRes.setAlert(true);
        apiRes.setData(bannerService.bannerList());
        apiRes.setSuccess(true);
        return apiRes;
    }

}
```