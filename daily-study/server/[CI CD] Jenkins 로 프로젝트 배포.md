# [CI/CD] Jenkins 로 프로젝트 배포

- Git 플러그인 설치
    
    Jenkins 관리 → 플러그인 관리 →  [GitHub IntegrationVersion](https://plugins.jenkins.io/github-pullrequest) 설치
    

- Git 토큰발급
    
    Setting → Developer settings → Personal access tokens
    권한 확인 후 새로운 토큰 발급 !
    
- credential 계정 추가
    
    Jenkins 관리 → Manage Credentials → ****Global credentials → Add Credentials****
    
    - Password : 발급 받은 git token 입력
    - ID : git 아이디 입력
        
        ![스크린샷 2022-05-19 오후 6.21.15.png](%5BCI%20CD%5D%20Jenkins%20%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20%E1%84%87%E1%85%A2%E1%84%91%E1%85%A9%20ae0290a66fa9426987def082dce1045e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-19_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_6.21.15.png)
        
    
- CI / CD 를 연결할 프로젝트 생성
    
    New Project → FreeStyle Project
    

- General
    
    ![스크린샷 2022-05-19 오후 6.27.11.png](%5BCI%20CD%5D%20Jenkins%20%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20%E1%84%87%E1%85%A2%E1%84%91%E1%85%A9%20ae0290a66fa9426987def082dce1045e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-19_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_6.27.11.png)
    
- 소스 코드 관리

![스크린샷 2022-05-19 오후 6.27.36.png](%5BCI%20CD%5D%20Jenkins%20%E1%84%85%E1%85%A9%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20%E1%84%87%E1%85%A2%E1%84%91%E1%85%A9%20ae0290a66fa9426987def082dce1045e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-05-19_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_6.27.36.png)

생성한  Credentials 설정

- 빌드 유발
    
    **GitHub hook trigger for GITScm polling 체크 하면 Commit 하면 프로젝트가 배포됨**