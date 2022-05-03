# Mac 에서 Docker 컨테이너 개발환경

<aside>
💡 사용중인 Mac의 로컬환경에 개발을 위해 필요한  Docker 컨테이너 설치 해보기

</aside>

# Docker 설치 하기

- 다운로드 url

[Install Docker Desktop on Mac](https://docs.docker.com/desktop/mac/install/)

```bash
docker -v
```

![스크린샷 2022-05-02 오전 10.45.23.png](Mac%20%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20Docker%20%E1%84%8F%E1%85%A5%E1%86%AB%E1%84%90%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%82%E1%85%A5%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%E1%84%92%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC%2027a8a66025f647f7b5b79c50199b49b9/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-02_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_10.45.23.png)

## Ubuntu 설치하기

```bash
docker run ubuntu:20.04
// 로컬에 이미지가 없을시 원격에서 다운로드됨
```

```bash
docker run --restart always --name ubuntu_20.04 -dt ubuntu:20.04
// 다운로드 한 이미지로 도커 컨테이너 생성 
```

```bash
docker ps
// 도커 컨테이너 목록 확인 
```

![스크린샷 2022-05-02 오전 10.53.11.png](Mac%20%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20Docker%20%E1%84%8F%E1%85%A5%E1%86%AB%E1%84%90%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%82%E1%85%A5%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%E1%84%92%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC%2027a8a66025f647f7b5b79c50199b49b9/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-02_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_10.53.11.png)

```bash
docker exec -it ubuntu_20.04 /bin/bash 
// 도커 실행 
```

![스크린샷 2022-05-02 오전 10.55.49.png](Mac%20%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20Docker%20%E1%84%8F%E1%85%A5%E1%86%AB%E1%84%90%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%82%E1%85%A5%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%E1%84%92%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC%2027a8a66025f647f7b5b79c50199b49b9/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-02_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_10.55.49.png)

- 실제 ubuntu 내부처럼 구성되어 있음

### docker 명령어

```bash
docker stop [컨테이너 ID]
// 도커 실행 중지 

docker rm [컨테이너 ID]
// 도커 컨테이너 삭제 

docker rmi [이미지 ID]
// 도커 이미지 삭제 
```

## Mysql 설치

```bash
docker search mysql 
// 이미지 검색 

NAME                             DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
mysql                            MySQL is a widely used, open-source relation…   12499     [OK]       
mariadb                          MariaDB Server is a high performing open sou…   4810      [OK]       
mysql/mysql-server               Optimized MySQL Server Docker images. Create…   925                  [OK]
percona                          Percona Server is a fork of the MySQL relati…   575       [OK]       
phpmyadmin                       phpMyAdmin - A web interface for MySQL and M…   520       [OK]       
mysql/mysql-cluster              Experimental MySQL Cluster Docker images. Cr…   93                   
centos/mysql-57-centos7          MySQL 5.7 SQL database server                   93                   
bitnami/mysql                    Bitnami MySQL Docker Image                      70                   [OK]
ubuntu/mysql                     MySQL open source fast, stable, multi-thread…   31                   
circleci/mysql                   MySQL is a widely used, open-source relation…   25                   
mysql/mysql-router               MySQL Router provides transparent routing be…   23                   
google/mysql                     MySQL server for Google Compute Engine          21                   [OK]
vmware/harbor-db                 Mysql container for Harbor                      10                   
bitnami/mysqld-exporter                                                          3                    
mysqlboy/docker-mydumper         docker-mydumper containerizes MySQL logical …   3                    
mysqlboy/mydumper                mydumper for mysql logcial backups              3                    
ibmcom/mysql-s390x               Docker image for mysql-s390x                    2                    
newrelic/mysql-plugin            New Relic Plugin for monitoring MySQL databa…   1                    [OK]
cimg/mysql                                                                       0                    
mysql/mysql-operator             MySQL Operator for Kubernetes                   0                    
ibmcom/tidb-ppc64le              TiDB is a distributed NewSQL database compat…   0                    
newrelic/k8s-nri-mysql           New Relic Infrastructure MySQL Integration (…   0                    
mysqlboy/elasticsearch                                                           0                    
mysqleatmydata/mysql-eatmydata                                                   0                    
mirantis/mysql                                                                   0
```

- 도커 이미지 다운로드 및 컨테이너 생성 , 실행

```bash
docker pull mysql:8.0.17
// mysql 8버전 다운로드 

docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=admin1 --name shop_dev mysql:8.0.17
// host 의 3306포트와 도커의 3306포트 연결
// mysql root 비밀번호 : admin1 로 세팅
// 컨테이너명 shop_dev
// 컨테이너 이미지 mysql:8.0.17

docker images

REPOSITORY   TAG       IMAGE ID       CREATED       SIZE
ubuntu       20.04     53df61775e88   2 days ago    72.8MB
mysql        8.0.17    b8fd9553f1f0   2 years ago   445MB

docker ps

CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS         PORTS                               NAMES
8a3ed707f706   mysql:8.0.17   "docker-entrypoint.s…"   7 seconds ago   Up 6 seconds   0.0.0.0:3306->3306/tcp, 33060/tcp   shop_dev

docker exec -it shop_dev bash // mysql 접속

root@8a3ed707f706:/# mysql -u root -p // 비밀번호 입력

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.00 sec)
```

- 도커 대시보드 확인

![스크린샷 2022-05-02 오후 1.07.12.png](Mac%20%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20Docker%20%E1%84%8F%E1%85%A5%E1%86%AB%E1%84%90%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%82%E1%85%A5%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%E1%84%92%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC%2027a8a66025f647f7b5b79c50199b49b9/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-02_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1.07.12.png)

## Nginx 설치

```bash
docker pull nginx 
// latest 버전으로 다운로드됨

docker images
// 다운로드된 도커 이미지확인

REPOSITORY   TAG       IMAGE ID       CREATED       SIZE
ubuntu       20.04     53df61775e88   3 days ago    72.8MB
nginx        latest    fa5269854a5e   12 days ago   142MB
mysql        8.0.17    b8fd9553f1f0   2 years ago   445MB

docker run -d --name web_engine -p 80:80 nginx
// host 80 포트와 도커 이미지 80 포트 사용
// 컨테이너명은 web_engine
```