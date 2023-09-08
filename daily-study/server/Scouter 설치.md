# [Server] - Scouter 설치

## 1. Scouter ?

```
scouter는 LG CNS에서 개발한 APM(Application Performance Monitoring) 도구 

기본적인 사용방법이 간단하며 Windows, Mac OS X, Linux와 같은 다양한 OS를 지원
```

## 3. Scouter 설치

<aside>
💡 Linux서버에 Tomcat 으로 구성된 WAS 와 Window에 설치된 Scouter client 로 환경을 세팅

</aside>

### 1. Scouter Client 를 Window 환경에 설치

- 설치파일 다운로드 링크

**[github.com/scouter-project/scouter/releases](https://github.com/scouter-project/scouter/releases)**

- 설치파일 실행

![Untitled](%5BTMS%5D-%20Scouter%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%206478b0b600a046e0a67ff92ac77b3b6b/Untitled.png)

```bash
C 드라이브에 다운로드 후 압축 해제 시 scouter.client 디렉토리가 생성됨

C:\scouter\scouter.client에서 **scouter.exe** 파일 실행
```

- 접속 정보 입력
    - 기본 포트 : 6001
    - id / pw : admin / admin

### 2. Linux 에 Scouter 설치

- wget 설치

```bash
$ wget https://github.com/scouter-project/scouter/releases/download/v2.8.1/scouter-all-2.8.1.tar.gz
```

- 압축 해체

```bash
tar -xvf scouter-all-2.12.0.1.SNAPSHOT.tar.gz
# scouter 디렉토리 아래 설치파일 생성됨

drwxr-xr-x 3 root root  166  9월  8 14:11 agent.batch
drwxr-xr-x 5 root root  270  9월  8 14:30 agent.host
drwxr-xr-x 5 root root  117  9월  8 14:51 agent.java
drwxr-xr-x 4 root root   57  9월  8 14:11 agent.java_6_7
drwxr-xr-x 2 root root  174  9월  8 15:03 logs
drwxr-xr-x 7 root root 4096  9월  8 14:25 server
drwxr-xr-x 5 root root  218  9월  8 14:11 webapp
```

### Scouter Server 실행

<aside>
💡 기본적으로 로컬환경에서 실행 되게 되어있음.

</aside>

- 실행

```bash
cd /{scouter설치경로}/server
./startup.sh

# 윈도우 실행시
./startup.bat
```

![Untitled](%5BTMS%5D-%20Scouter%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%206478b0b600a046e0a67ff92ac77b3b6b/Untitled%201.png)

→ Scouter Client 에 Linux 서버가 추가 된 것을 확인 할 수 있음

![Untitled](%5BTMS%5D-%20Scouter%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%206478b0b600a046e0a67ff92ac77b3b6b/Untitled%202.png)

- conf 파일에서 별도로 설정 가능
    - 연결 시 Scouter Client 의 Collector > Configures > Configure 에서 설정/변경 가능

```bash
vi /{scouter설치경로}/server/conf/scouter.conf

net_collector_ip=10.147.1.217
net_collector_udp_port=6100
net_collector_tcp_port=6100      

log_dir=/home/tms/scouter/logs   # 로그 경로
```

### Host Agent ****실행****

<aside>
💡 **Host Agent는 OS의 CPU, memory, disk 사용량 등의 정보를 파악할 수 있게 해준다**

**OS 당 하나씩만 설정하면됨**

</aside>

- 실행 파일

```bash
cd /{scouter설치경로}/agent.host
./host.sh   # 실행
./stop.sh   # 종료

# 윈도우 실행시
./host.bat
```

![Untitled](%5BTMS%5D-%20Scouter%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%206478b0b600a046e0a67ff92ac77b3b6b/Untitled%201.png)

- 설정파일

```bash
vi /{scouter설치경로}/agent.host/conf/scouter.conf

## 필요한 부분 주석 해제 후 사용
net_collector_ip=10.147.1.217
net_collector_udp_port=6100
net_collector_tcp_port=6100
#cpu_warning_pct=80
#cpu_fatal_pct=85
#cpu_check_period_ms=60000
#cpu_fatal_history=3
#cpu_alert_interval_ms=300000
#disk_warning_pct=88
#disk_fatal_pct=92
obj_name=WAS-01  
```

### ****Java Agent 실행****

<aside>
💡 **Heap Memory, Thread,TPL 등의 Java Application 성능 정보를 파악할 수 있게 해준다.**

</aside>

- 실행 파일

```bash
cd /{scouter설치경로}/agent.java/scouter.agent.jar
# 해당 경로의 agent 를 통해 모니터링 데이터 수집 됨
# 별도로 실행하지 모니터링 필요한 애플리케이션 실행 스크립트에 추가 
```

- 설정파일

```bash
vi /{scouter설치경로}/agent.java/conf/scouter.conf

## 필요한 부분 주석 해제 후 사용
## 여러대 사용시 다중으로 설정

obj_name=WAS-01  # obj_name 설정시 clinet 에서 해당 명으로 확인 가능
net_collector_ip=121.0.0.1
net_collector_udp_port=6100
net_collector_tcp_port=6100
#hook_method_patterns=sample.mybiz.*Biz.*,sample.service.*Service.*
#trace_http_client_ip_header_key=X-Forwarded-For
#profile_spring_controller_method_parameter_enabled=false
#hook_exception_class_patterns=my.exception.TypedException
#profile_fullstack_hooked_exception_enabled=true
#hook_exception_handler_method_patterns=my.AbstractAPIController.fallbackHandler,my.ApiExceptionLoggingFilter.handleNotFoundErrorResponse
#hook_exception_hanlder_exclude_class_patterns=exception.BizException
```

### 3. Tomcat 애플리케이션에 추가

- catalina.sh

```bash
if [ "$1" = "start" -o "$1" = "run" ]; then
JAVA_OPTS=" ${JAVA_OPTS} -javaagent:${SCOUTER_AGENT_DIR}/scouter.agent.jar"
JAVA_OPTS=" ${JAVA_OPTS} -Dscouter.config=${SCOUTER_AGENT_DIR}/conf/scouter.conf"
JAVA_OPTS=" ${JAVA_OPTS} -Dobj_name=WAS-01"
fi
```

- start.sh

```bash
JAVA_OPTS=" ${JAVA_OPTS} -javaagent:${SCOUTER_AGENT_DIR}/scouter.agent.jar"
JAVA_OPTS=" ${JAVA_OPTS} -Dscouter.config=${**SCOUTER_AGENT_DIR**}/conf/scouter.conf"
JAVA_OPTS=" ${JAVA_OPTS} -Dobj_name=WAS-01"
```

- tomcat 재실행

```bash
./{tomcat설치경로}/bin/shutdown.sh
./{tomcat설치경로}/bin/startup.sh

# tomcat 재실행 후 로그 확인시 아래와 같이 scouter 실행 로그와 함께 rest api 등이
# 매핑 된 것을 확인 할 수 있음
```

![Untitled](%5BTMS%5D-%20Scouter%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%206478b0b600a046e0a67ff92ac77b3b6b/Untitled%203.png)

→ Scouter Clinet 에서 Tomcat 추가 된 것 확인