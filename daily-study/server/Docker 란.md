# Docker 란?

![https://blog.kakaocdn.net/dn/bHnmw3/btrqGrsEEwp/4SEEe3r8K4PuUnCd14tXEK/img.png](https://blog.kakaocdn.net/dn/bHnmw3/btrqGrsEEwp/4SEEe3r8K4PuUnCd14tXEK/img.png)

> Docker 란 무엇인가?
> 
- 리눅스 컨테이너 기반 가상화 도구
- 개발자들에게 도움이 되도록 설계된 개방형 애플리케이션 개발 프레임워크
- Go 언어로 개발

> Docker 의 장점
> 
- 간결하고 빠른 실행 속도 : 각각의 OS 로 동작하는 VM과는 달리 하나의 host OS 위에 컨테이너를 설치하여 가동하기 때문에 수초 이내로 실행가능
- 자원의 비용절감 효과 : 하나의 물리적 서버에 여러개의 컨테이너를 가동시킬수 있음
- 빠른 확장성 : 애플리케이션을 작동시키는것과 같이 프로젝트의 실행, 배포 환경을 구축할 수 있음

> Docker의 컨테이너와 VM(가상머신)
> 

![https://blog.kakaocdn.net/dn/OlGzK/btrqME4BTLa/86qohsqFuas0eE5tSl9GI1/img.png](https://blog.kakaocdn.net/dn/OlGzK/btrqME4BTLa/86qohsqFuas0eE5tSl9GI1/img.png)

**VM(가상머신)**

- 하나의 물리적 시스템을 가상화 시킨것
- cpu, 메모리, 하드디스크등을 가상화시켜 동작하는 것으로 부팅하는데 속도가 더딤

- 각각의 VM은 OS를 가지고 있어야하고 이를 기반으로 bin/lib 가 실행 됨

**Docker 컨테이너**

- 하나의 Host OS 위에 여러개의 컨테이너가 앱 형태로 동작하는 구조
- 컨테이너 별로 각각 프로세스마다 bin/libs 가 실행됨
- OS가 시작된후 컨테이너를 가동시키는 것으로 부팅하는데 수초 밖에 안걸림