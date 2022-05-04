# [Docker] Docker 네트워크

## 도커 네트워크의 종류

```bash
docker network ls

NETWORK ID     NAME      DRIVER    SCOPE
758e97b34e91   bridge    bridge    local
6a7ca0a65847   host      host      local
a3b4cc438c0f   none      null      local
```

- 도커에서 사용할 수 있는 네트워크 종류는 bridge, host, none등이 있음
- Docker를 설치하게 되면 Host의 네트워크 인터페이스에  **docker0**  라는 가상인터페이스 생성됨.
- 도커 컨테이너 생성시 외부와 통신을 위한 인터페이스 
     - 컨테이너 내부 Namespace에 할당되는`eth0`
     - 호스트 네트워크 브리지 `docker0`에 바인딩 되는 `vethXXXXXXX`이름 형식의 **veth 인터페이스
를 생성함**

### 도커 브릿지를 이용한 외부와 통신

```bash
docker network inspect bridge
// 브릿지 네트워크 상세 정보

[
    {
        "Name": "bridge",
        "Id": "758e97b34e91bedc4d96c749c232fa279fde686564e9ebb8796b6378b5952a84",
        "Created": "2022-05-02T01:43:07.485192175Z",
        "Scope": "local",
        "Driver": "bridge",
        "EnableIPv6": false,
        "IPAM": {
            "Driver": "default",
            "Options": null,
            "Config": [
                {
                    "Subnet": "172.17.0.0/16"
                }
            ]
        },
        "Internal": false,
        "Attachable": false,
        "Ingress": false,
        "ConfigFrom": {
            "Network": ""
        },
        "ConfigOnly": false,
        "Containers": {
            "a4c98abfcda9d8a079b8c4594cf52077d5d7ec9da2b21e751f1b0279eb4db4dd": {
                "Name": "ubuntu20",
                "EndpointID": "e6447de36049edfb4cd3a8171128f7cc3c746b80cc8c9803477b0da4b43aff8c",
                "MacAddress": "02:42:ac:11:00:02",
                "IPv4Address": "172.17.0.2/16",
                "IPv6Address": ""
            }
        },
        "Options": {
            "com.docker.network.bridge.default_bridge": "true",
            "com.docker.network.bridge.enable_icc": "true",
            "com.docker.network.bridge.enable_ip_masquerade": "true",
            "com.docker.network.bridge.host_binding_ipv4": "0.0.0.0",
            "com.docker.network.bridge.name": "docker0",
            "com.docker.network.driver.mtu": "1500"
        },
        "Labels": {}
    }
]
```

- `docker0` 인터페이스는 `172.17.0.0/16` 서브넷을 갖기 때문에 도커 컨테이너가 생성되면 이 대역 안에서 IP를 순차적으로 할당받게 됨
- `docker0` 브릿지는 `veth` 가상 인터페이스와 호스트 `eth0` 를 이어주는 중간다리 역할을 수행
- 컨테이너 안의 `eth0` 인터페이스는 `veth` 가상 인터페이스를 통해 외부와 통신 할 수 있게됨
    
    

```bash
docker exec -it ubuntu20 ip addr

1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
30: eth0@if31: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default 
    link/ether 02:42:ac:11:00:02 brd ff:ff:ff:ff:ff:ff link-netnsid 0
    inet 172.17.0.2/16 brd 172.17.255.255 scope global eth0
       valid_lft forever preferred_lft forever
```

- `eth0` 인터페이스에 `172.17.0.2` IP가 할당 되어 있음

```bash
ip link
// veth 인터페이스 생성된 것 확인 

brctl show
//veth 인터페이스가 docker0 에 연결된 것 확인

docker exec -it ubuntu20 route
// 컨테이너 내부의 패킷이 host의 docker0을 통해 외부와 통신
Kernel IP routing table
Destination     Gateway         Genmask         Flags Metric Ref    Use Iface
default         172.17.0.1      0.0.0.0         UG    0      0        0 eth0
172.17.0.0      0.0.0.0         255.255.0.0     U     0      0        0 eth0
```

## 컨테이너에서 Mac 으로 통신

<aside>
💡 Mac 환경에서는 `docker0` 네트워크 인터페이스가 없음
- 브릿지 환경에서의 통신이 불가능
- p 옵션을 통해 포트간 바인딩을 해주거나
- 특수 도메인을 사용해 host 와 통신
      host.docker.internal 
           : 도커에서 제공하는 특수한 도메인, 도커컨테이너에서 외부 Mac 호스트에 접근 가능하게 해줌.
      gateway.docker.internal
           : gateway 사용시에도 적용가능

</aside>

- host.docker.internal  사용 Mac host와 통신

```bash
curl host.docker.internal:8080
// 도커 내부에서 Host 8080으로 접근
// mac 로컬에는 8080 포트에 톰캣 연결
```

- etc

```bash
brew install iproute2mac
// zsh: command not found: ip 오류 출력시
```