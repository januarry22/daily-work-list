# [Spring] Spring Framework

## 1. Spring Framework이란?

- 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임 워크
- 엔터프라이즈급 애플리케이션을 개발 하기 위한 모든 기능을 종합적으로 제공하는 경량화된 솔루션

## 2. Spring Framework 의 특징

### Spring Framework 는 IoC(Inversion of Control, 제어의 역전) 기반

```html
IoC(Inversion of Control, 제어의 역전) ?

IOC란, 기존 개발자가 제어하던 객체 제어의 흐름(객체를 직접 생성하여 메소드 호출)을 
컨테이너에 위임하는 것으로 인스턴스의 생성부터 소멸까지 개발자가 아닌 컨테이너가 대신 관리해주는 것을 의미
인스턴스 생성의 제어를 서블릿과 같은 Bean을 관리해주는 컨테이너가 관리한다

* Bean : Spring에 의하여 생성되고 관리되는 자바 객체를 의미
```

- IoC는 DI, DL 에 의해 구현됨
    - **DL(Dependency Lookup, 의존성 검색)** : 컨테이너에서는 객체들을 관리하기 위해 별도의 저장소에 빈을 저장하고 이것들을 개발자들이 컨테이너에서 사용하고자하는 Bean 을 검색하는 것
    - **DI (Dependency Injection, 의존성 주입)** : 각 클래스 사이에 필요로 하는 의존관계를 Bean 설정 정보 바탕으로 컨테이너가 자동으로 연결합니다.

### POJO(Plain Old Java Object)

```html
평범한 자바 오브젝트를 의미함.
getter/setter를 가진 단순 자바 오브젝트로 정의되며, 의존성이 없고 테스트 및 유지보수에 용이함
```

### AOP(Aspect Oriented Programming)

```html
공통의 관심 사항을 적용해서 발생하는 의존 관계의 복잡성과 코드 중복을 해소함.
각 클래스에서 공통 관심 사항을 구현한 모듈에 대한 의존관계를 갖기 보단, 
Aspect를 이용해 핵심 로직을 구현한 각 클래스에 공통 기능을 적용시킨다.
```

## 3. Spring Boot?

- 스프링에서 사용하는 프로젝트를 간편하게 셋업할 수 있는 서브 프로젝트
- 독립 컨테이너에서 동작할 수 있기 때문에 임베디드 톰켓이 자동으로 실행

###