# [Spring] - Spring Batch

## 1. Spring Batch ?

- Spring Batch는 엔터프라이즈급 시스템의 운영에 있어 대용량 일괄처리의 편의를 위해 설계된 가볍고 포괄적인 배치 프레임워크
- Spring 기반의 DI, AOP, 서비스 추상화등 사용가능 특성을 그대로 가져와 사용가능함

## 2. 배치 애플리케이션의 특징

- **대용량 데이터** : 배치 어플리케이션은 대량의 데이터를 가져오거나, 전달하거나, 계산하는 등의 처리를 할 수 있어야함
- **자동화** : 배치 어플리케이션은 심각한 문제 해결을 제외하고는 **사용자 개입 없이 실행**되어야함
- **견고성** : 배치 어플리케이션은 잘못된 데이터를 충돌/중단 없이 처리할 수 있어야함
- **신뢰성** : 배치 어플리케이션은 무엇이 잘못되었는지를 추적할 수 있어야함(로깅, 알림)
- **성능** : 배치 어플리케이션은 **지정한 시간 안에 처리를 완료**하거나 동시에 실행되는 **다른 어플리케이션을 방해하지 않도록 수행되어야함**

<aside>
💡 Spring Quartz vs Spring Batch

Spring Quartz**는 스케줄러의 역할,** Spring ****Batch 와 같이 **대용량 데이터 배치 처리에 대한 기능을 지원하지 않음**

반대로 Batch 역시 Quartz의 다양한 스케줄 기능을 지원하지 않음

정해진 스케줄마다 Quartz가 Spring Batch를 실행하는 구조로 병합해서 사용

</aside>

## 3. Spring Batch 구성

- JobRepository
다양한 배치 수행에 관련된 수치 데이터와 Job의 상태를 유지 및 관리
실행된 Step, 현재 상태, 읽은 아이템 및 처리된 아이템 수 등이 모두 JobRepository에 저장
- Job
배치 처리 과정을 하나의 단위로 만들어 표현한 객체이고 여러 Step 인스턴스로 이루어짐
- JobLauncher
Job을 실행하는 역할을 담당. Job의 재실행 가능 여부 검증, 실행 방법, 유효성 검증 등을 수행
- Step
스프링 배치에서 가장 일반적으로 상태를 보여주는 단위. 각 Step은 Job을 구성하는 독립된 작업의 단위Tasklet, Chunk기반으로 2가지 있음 주로 Chunk 지향 처리
    - Tasklet
    Step이 중지 될 때 까지 execute 메서드가 계속 반복해서 수행되고 이때마다 독립적인 트랜잭션 수행
    초기화, 저장 프로시저 실행, 알림 전송과 같은 Job에서 일반적으로 사용
    - Chunk
    **한번에 하나씩 데이터(row)를 읽어 Chunk라는 단위로 만든뒤 트랜잭션을 수행**
    이 Chunk 단위로 수행되기 때문에 실패할 경우 해당 Chunk 만큼 롤백, 이전 커밋된 트랜잭션은 반영
    
    ```html
    - Chunk 기반의 Step
    1) ItemReader
    		: File, DB, Java Message Service 다른 소스데이터 등을 읽어옴
    	- **Cursor 방식**
    	  Streaming 개념. DB와 커넥션을 맺은 후, Cursor를 한칸씩 옮기며 지속적으로 데이터를 가져옴.
    		->JdbcCursorItemReader, HibernateCursorItemReader, StoredProcedureItemReader	
    	- **Paging 방식**
    		Page 단위로 한번에 데이터를 조회
    		->JdbcPagingItemReader, HibernatePagingItemReader, JpaPagingItemReader
    		
    2) ItemProcessor
    		: Reader에서 넘겨준 데이터 개별건을 가공/처리
    3) ItemWriter
    		: Spring Batch에서 사용하는 출력 기능. Chunk기반으로 처리
    			Reader와 Processor를 거쳐 처리된 Item을 Chunk 단위 만큼 쌓은 뒤 이를 Writer에 전달
    ```
    

## 4. Spring Batch Meta Table

- 배치 작업 하는동안 사용되는 모든 메타정보들 (작업 시간, 파라미터, 정상수행 여부)을 기록하여 작업 중에 사용하거나 모니터링 용도로 사용 할 수 있게 제공되는 기능
- Batch 를 사용하기 위해 사전에 스키마가 구성되어야함

![https://docs.spring.io/spring-batch/docs/current/reference/html/images/meta-data-erd.png](https://docs.spring.io/spring-batch/docs/current/reference/html/images/meta-data-erd.png)

- **BATCH_JOB_INSTANCE** : 배치 Job의 생성정보
- **BATCH_JOB_EXECUTION :** 배치 Job의 실행정보
- **BATCH_JOB_EXECUTION_PARAM :** 배치 Job에서 사용되는 파라미터 값
- **BATCH_JOB_EXECUTION_CONTEXT : Job 실행중** 사용되는 모든 정보가 기록되는 Context를 저장
- **BATCH_STEP_EXECUTION :** 배치 Step의 실행정보
- **BATCH_STEP_EXECUTIOIN_CONTEXT : Step 실행중** 사용되는 모든 정보가 기록되는 Context를 저장

---

- 참고 링크
    
    [Meta-Data Schema](https://docs.spring.io/spring-batch/docs/current/reference/html/schema-appendix.html)