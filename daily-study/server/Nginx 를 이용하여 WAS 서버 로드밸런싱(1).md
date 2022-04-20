# Nginx 를 이용하여 WAS 서버 로드밸런싱(1)

### **Nginx 를 이용하여 WAS 서버 로드밸런싱(1)**

이번 포스팅에서는 Nginx (Web Server) 을 이용하여 Tomcat (WAS)을 로드밸런싱 해보겠습니다.

> Web Server 와 WAS 에 관한글
> 

[2022.01.12 - [서버 | 네트워크] - Web Server 와 WAS](https://january22.tistory.com/16)

[](https://january22.tistory.com/16)

### **1 ) 로드밸런싱 이란 무엇인가?**

> 로드밸런싱이란, 서버에 가해지는 부하(load)를 분산(balancing) 해주는 장치 또는 기술을 의미합니다. 대용량의 트래픽을 여러대의 서버로 분산시켜 한 곳에만 집중 되지 않도록 함으로써 클라이언트의 요청에 대하여 일관성을 높일 수 있습니다.
> 

- **Scale Up 과 Scale Out**

![https://blog.kakaocdn.net/dn/bnbivy/btrrjA1KRq6/zQMRTsdkOED6nSXlor1k51/img.png](https://blog.kakaocdn.net/dn/bnbivy/btrrjA1KRq6/zQMRTsdkOED6nSXlor1k51/img.png)

**Scale Up**

: 성능이나 용량 증강을 목적으로 하나의 서버에 디스크를 추가하거나 CPU나 메모리를 업그레이드시키는 것으로, 수직 스케일링(vertical scaling)이라고도함

**Scale Out**

: 동일하거나 사양이 낮은 서버를 추가시켜 서버의 역할을 분산시켜 주는 것으로, 서버의 트래픽을 균등하게 배분할수 있도록 로드밸런싱이 필요함

### **2 ) 로드밸런싱 알고리즘**

- **라운드로빈 방식(Round Robin Method)**서버에 들어온 요청을 순서대로 돌아가며 배정하는 방식입니다. 클라이언트의 요청을 순서대로 분배하기 때문에 여러 대의 서버가 동일한 스펙을 갖고 있고, 서버와의 연결(세션)이 오래 지속되지 않는 경우에 활용하기 적합합니다.
- **가중 라운드로빈 방식(Weighted Round Robin Method)**각각의 서버마다 가중치를 매기고 가중치가 높은 서버에 클라이언트 요청을 우선적으로 배분합니다. 주로 서버의 트래픽 처리 능력이 상이한 경우 사용되는 부하 분산 방식입니다. 예를 들어 A라는 서버가 5라는 가중치를 갖고 B라는 서버가 2라는 가중치를 갖는다면, 로드밸런서는 라운드로빈 방식으로 A 서버에 5개 B 서버에 2개의 요청을 전달합니다.
- **IP 해시 방식(IP Hash Method)**클라이언트의 IP 주소를 특정 서버로 매핑하여 요청을 처리하는 방식입니다. 사용자의 IP를 해싱해(Hashing, 임의의 길이를 지닌 데이터를 고정된 길이의 데이터로 매핑하는 것, 또는 그러한 함수) 로드를 분배하기 때문에 사용자가 항상 동일한 서버로 연결되는 것을 보장합니다.
- **최소 연결 방식(Least Connection Method)**요청이 들어온 시점에 가장 적은 연결상태를 보이는 서버에 우선적으로 트래픽을 배분합니다. 자주 세션이 길어지거나, 서버에 분배된 트래픽들이 일정하지 않은 경우에 적합한 방식입니다.
- **최소 리스폰타임(Least Response Time Method)**서버의 현재 연결 상태와 응답시간(Response Time, 서버에 요청을 보내고 최초 응답을 받을 때까지 소요되는 시간)을 모두 고려하여 트래픽을 배분합니다. 가장 적은 연결 상태와 가장 짧은 응답시간을 보이는 서버에 우선적으로 로드를 배분하는 방식입니다
- 출처 : [https://m.post.naver.com/viewer/postView.naver?volumeNo=27046347&memberNo=2521903](https://m.post.naver.com/viewer/postView.naver?volumeNo=27046347&memberNo=2521903)