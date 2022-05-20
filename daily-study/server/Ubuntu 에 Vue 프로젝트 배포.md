# Ubuntu 에 Vue 프로젝트 배포

### Nginx 이용해서 배포하기

- Nginx 설치 참고

[Server](https://www.notion.so/Server-c97a6ffd43e242a1837544471265e176)

- Nginx 설정파일

```bash
sudo /etc/nginx/sites-available/
// nginx 설정파일 경로 (ubuntu 18 기준)
sudo vi default 
// 기본 설정 파일
```

- root 경로 변경

```bash
server {
        listen 80 default_server;
        listen [::]:80 default_server;
        root /var/lib/jenkins/workspace/oneourbe-front-ci/dist;
        server_name _;

        location / {
                # First attempt to serve request as file, then
                # as directory, then fall back to displaying a 404.
                try_files $uri $uri/ =404;
        }
}
```

- root 경로를 jenkins 워크스페이스에 생성된 vue 프로젝트로 연결
- 기준 디렉토리는 dist 로 설정

<aside>
💡 도메인 으로 접속하면 vue 프로젝트 실행 !

</aside>