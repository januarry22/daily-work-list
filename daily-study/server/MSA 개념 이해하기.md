# MSA 개념 이해하기

### **MSA 란 무엇인가?**

> 마이크로 서비스 아키텍처(Micro Service Architecture)의 의 약자로 단일프로그램을 각 컴포넌트별로 나누어 작은 서비스의 조합을 구축하는 방법입니다.
> 
- **MSA 등장배경**

> Monolithic Architecture
> 

![https://blog.kakaocdn.net/dn/bhJfby/btrsrPRsjsW/WKAnc7rL8c4B66LN9nyYnK/img.png](https://blog.kakaocdn.net/dn/bhJfby/btrsrPRsjsW/WKAnc7rL8c4B66LN9nyYnK/img.png)

- **MSA 의 특징**
- 어플리케이션 확장이 용이함으로 개발 생산성과 속도가 증가하며, 최신 기술로 교체가 용이함.
- 각각의 비즈니스를 나눠서 수행하기 때문에 한가지 언어 또는 프레임워크에 종속되지 않고 사용 가능.
- 단일 책임 원칙(Single Responsibility Principle; SRP)을 중시함. 큰 단위의 컴포넌트들을 작게 분해하여 서비스가 서로 영향을 미치지 않고 독립적으로 역할을 수행하게 만듬으로써 서비스 단위 간에 영향을 미치지 않게함.
- 지속적인 통합(continuous integration;CI)과 지속적인 배포(continuous delivery;CD)가 필수적임.
- **MSA 의 단점**
- 작은 서비스단위로 개발하기 때문에 서비스간 통신방법이 필요하며 산출된 데이터의 중복이 발생하는 등 무결성을 보장하기 어려움.
- 서비스간 호출 API 통신을 이용하기 때문에 속도가 느리고, 오버헤드가 발생 할 수 있음.
- 서비스마다의 인력관리가 분리 되어있어 협업에 장애가 발생하면 개발 속도가 지연될 수 있음.
- **모놀리식과 마이크로서비스의 공통점**

> 클라이언트 트래픽이 증가하면 어플리케이션 Server를 추가함으로써 수평적으로 확장하거나 요청이 들어오면 중간에 로드밸런서(Load Balencer)를 두어서 스케일 아웃(Scale-out)방식으로 서버를 추가하여 확장하게 됩니다.
> 

- 스케일 아웃(Scale-out) : 여러대의 Server로 나누어 일을 처리하는 방법
- 스케일 업(Scale-up) : Server가 더 빠르게 동작하게 하기 위해 하드웨어 성능을 올리는 방법
- 로드 밸런서(Load Balancer) : 스케일 아웃의 장점 중 하나로, 여러 대의 Server에게 균등하게 Traffic을 분산시켜주는 역할을 담당