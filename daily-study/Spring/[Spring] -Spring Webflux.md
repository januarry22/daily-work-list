# [Spring] -Spring WebFlux

## ✏️ Index

## 1. ****Spring WebFlux 란?****

- Spring 5 에서 추가된 논블로킹(Non-Blocking)런타임에서 리액티브 프로그래밍을 할 수 있는 Web 프레임 워크

```
- **Blocking** 
	A 함수가 B 함수를 호출 할 때, B 함수가 자신의 작업이 종료되기 전까지 
	A 함수에게 제어권을 돌려주지 않는 것
- **Non-blocking** 
	A 함수가 B 함수를 호출 할 때, B 함수가 제어권을 바로 A 함수에게 넘겨주면서,
  A 함수가 다른 일을 할 수 있도록 하는 것.
- **동기 Synchronous**
	A 함수가 B 함수를 호출 할 때, B 함수의 결과를 A 함수가 처리하는 것.
- **비동기 Asynchronous**
	A 함수가 B 함수를 호출 할 때, B 함수의 결과를 B 함수가 처리하는 것. (callback)
```

- Spring MVC는 서블릿 컨테이너에 Servlet API를 기반으로 하였지만, Spring WebFlux는 Servlet API를 사용하지 않고 Reactive Streams와 그 구현체인 Reactor를 기반으로 한 새로운 HTTP API로 구현
- 순수한 `Publisher` (데이터 레퍼지토리)를 입력 받아 Mono 나 Flux를 반환

## 2. Spring WebFlux 의 모델

- **@Controlller (Annotation Controllers)**
    
    Spring MVC와 동일한 프로그래밍 방법을 사용 `@RestBody` 를 사용하여 인자를 전달받을 수 있음
    
- **Router Functions (Functional Endpoints)**
    
    람다 기반의 새로운 Controller 구현방법으로`POJO`에 `@RestController`과 `@GetMapping`등의 어노테이션을 선언하여 라우팅을 정의하는 대신에 경로와 핸들러 함수(람다)의 조합으로 라우팅을 정의
    
    `@Controller` 모델과 동시사용이 불가능하기 때문에 @Controller 는 무시됨
    
    어플리케이션이 요청을 처음부터 끝까지 제어함.
    

### ✔️ Spring WebFlux 와 Spring MVC

Spring MVC의 경우 어플리케이션이 처리중인 스레드가 (외부서버의 요청/호출)에 의해 잠시 중단 될 수 있으므로 서블릿컨테이너는 이 블로킹에 대하여 큰 쓰레드풀로 요청을 처리

Spring WebFlux 의 경우 **실행중인 쓰레드가 중단되지않는 것**이 전제. **작은 스레드을 고정해놓고 요청을 처리**함

## 3. Spring WebFlux 구현

- curl 명령어로 패키지 다운로드

```bash
curl https://start.spring.io/starter.tgz  \
       -d bootVersion=2.4.4 \
       -d dependencies=webflux \
       -d baseDir=spring-webflux \
       -d artifactId=webflux \
       -d packageName=com.januarry.webflux \
       -d applicationName=RunWebFluxApplication \
       -d type=gradle-project | tar -xzvf -
```

### @Controlller

- MainController 에 @RestController 명시

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MainController {

    @GetMapping("/")
    Flux<String> hello() {
        return Flux.just("Hello", "World");
    }
}
```

`Flux`는 Reactive Streams의 `Publisher`를 구현한 N 요소의 스트림을 표현하는 Reactor 클래스

- `text/plain`
- Server-Sent Event
- JSON Stream

데이터 형식으로 반환 가능.

### 무한 Stream 으로 구현해보기

```java
@GetMapping("/stream")
Flux<Map<String, Integer>> stream() {
     Stream<Integer> stream = Stream.iterate(0, i -> i + 1); 
     return Flux.fromStream(stream.limit(10))
     .map(i -> Collections.singletonMap("value", i));
}
```

- **JSON**

```bash
curl -i localhost:8080/stream
HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: application/json

[{"value":0},{"value":1},{"value":2},{"value":3},{"value":4},{"value":5},{"value":6},{"value":7},{"value":8},{"value":9}]%
```

- ****Server-Sent Event****

```bash
curl -i localhost:8080/stream -H 'Accept: text/event-stream'
HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: text/event-stream;charset=UTF-8

data:{"value":0}

data:{"value":1}

data:{"value":2}

data:{"value":3}

data:{"value":4}

data:{"value":5}

data:{"value":6}

data:{"value":7}

data:{"value":8}

data:{"value":9}
.....
무한 Stream 됨
```

- **JSON Stream**

```bash
curl -i localhost:8080/stream -H 'Accept: application/stream+json'

HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: application/stream+json

{"value":0}
{"value":1}
{"value":2}
{"value":3}
{"value":4}
{"value":5}
{"value":6}
{"value":7}
{"value":8}
{"value":9}
...
무한 Stream 됨
```

- `Flux.interval(Duration)와 zip` 으로 Stream 조절

```java
@GetMapping("/stream/interval")
Flux<Map<String, Integer>> interval() {
    Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
    return Flux.fromStream(stream).zipWith(Flux.interval(Duration.ofSeconds(1)))
            .map(tuple -> Collections.singletonMap("value", tuple.getT1()));
}
```

### POST Method 사용

- @RequestBody 사용해서 요청 본문을 받을 수 있음
- Spring WebFlux 에서는 Mono로 객체를 감싸 비동기적 처리를 chain/compose
    - Mono 로 감싸지 않으면 Non-blocking으로 동기화 처리됨
- 0~1건을 처리할땐 Mono를 사용하는 것이 명시적. 0 ~N 건의 Stream 처리시는 Flux

**Mono** 

```java
@PostMapping("/mono")
Mono<String> mono(@RequestBody Mono<String> body) {
	  return body.map(String::toUpperCase);
}
```

```bash
curl -i localhost:8080/mono -H 'Content-Type: application/json' -d stringupper

HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8
Content-Length: 11

STRINGUPPER
```

- **Flux**

```java
@PostMapping("/flux")
Flux<Map<String, Integer>> flux(@RequestBody Flux<Double> body) {
    Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
    return Flux.fromStream(stream).zipWith(Flux.interval(Duration.ofSeconds(1)))
           .map(tuple -> Collections.singletonMap("value", tuple.getT1() * 2));
}
```

```bash
curl -i localhost:8080/flux -d '{"value":1}{"value":2}{"value":3}' 
		 -H 'Content-Type: application/stream+json'  -H 'Accept: text/event-stream'

HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: text/event-stream;charset=UTF-8

data:{"value":0}

data:{"value":2}

data:{"value":4}

data:{"value":6}

data:{"value":8}

....
```

### ****Router Functions 모델****

- **@Bean 주입**

```java
@Component
public class RouterFunctionTest {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/"), this::hello)
                .andRoute(GET("/stream"), this::stream)
                .andRoute(POST("/echo"), this::echo)
                .andRoute(POST("/stream"), this::postStream);

    }

    public Mono<ServerResponse> hello(ServerRequest req) {
        return ok().body(Flux.just("Hello", "World!"), String.class);
    }

    public Mono<ServerResponse> stream(ServerRequest req) {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
        Flux<Map<String, Integer>> flux = Flux.fromStream(stream)
                .map(i -> Collections.singletonMap("value", i));
        return ok().contentType(MediaType.APPLICATION_NDJSON)
                .body(fromPublisher(flux, new ParameterizedTypeReference<Map<String, Integer>>(){}));
    }

    public Mono<ServerResponse> echo(ServerRequest req) {
        Mono<String> body = req.bodyToMono(String.class).map(String::toUpperCase);
        return ok().body(body, String.class);
    }

    public Mono<ServerResponse> postStream(ServerRequest req) {
        Flux<Map<String, Integer>> body = req.body(toFlux(
                new ParameterizedTypeReference<Map<String, Integer>>(){}));

        return ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(fromPublisher(body.map(m -> Collections.singletonMap("double", m.get("value") * 2)),
                        new ParameterizedTypeReference<Map<String, Integer>>(){}));
    }
}
```

- Request Body를 Generics 형태의 `Publisher`으로 받을 경우`ServerRequest.bodyToFlux`
가 아닌 `ServerRequest.body`메소드에 BodyInserters와 반대의 개념인 BodyExtractors
을 전달
- `@RequestMapping` →`RequestPredicates.path`
- `@GetMapping` → `RequestPredicates.GET`
- `@PostMapping` → `RequestPredicates.POST`

```bash
curl -i localhost:8080
HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: text/plain;charset=UTF-8

HelloWorld!

curl -i localhost:8080/stream
...
{"value":219426}
{"value":219427}
{"value":219428}
{"value":219429}
....

curl -i localhost:8080/stream -d '{"value":1}{"value":2}{"value":3}' 
		 -H 'Content-Type: application/stream+json'  -H 'Accept: text/event-stream'

HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: text/event-stream;charset=UTF-8

data:{"double":2}

data:{"double":4}

data:{"double":6}
```