# [DB] - Oracle | Table Space

### 1. Table Space 란?

- Oracle 에서는 Data file 이라는 물리적 파일 형태를 저장하고 이러한 Data file 이 하나 이상 모여서 Table Space라는 논리적 공간을 형성

### 2. Table Space 의 생성 및 관리

- Oracle에서는 Table Space 를 먼저 생성하여 테이블이 저장될 공간을 만들고, 테이블을 생성
- 각각의 테이블을 스페이스별로 나누어 관리함으로써 성능향상
- Table Space 생성시 정의된 용량만큼 저장공간이 확보되어 데이터가 저장

```sql
CREATE TABLESPACE <테이블스페이스명>
DATAFILE '<경로>'
SIZE <크기> 
[
AUTOEXTEND ON NEXT 10M
maxsize 100M
EXTENT MANAGEMENT LOCAL
uniform SIZE <크기>
]
;

# 테이블스페이스 testTS 를 생성하고 100MB 로 정의, ‘5MB’씩 자동 증가 옵션
# 여기서 oracle이 설치된 경로에 .dbf 파일을 생성함
# 논리적개념인 테이블 스페이스는 물리적인 파일로 존재하므로 실제 저장될 파일과 경로 설정하여야함.
CREATE TABLESPACE testTS
DATAFILE '\app\oracle\testTS.dbf' 
SIZE 100M AUTOEXTEND 
ON NEXT 5M;

# 테이블 스페이스 삭제시
# contents : 모든 세그먼트를 삭제
# datafiles : 모든 데이터파일까지 삭제 ( 실제 경로의 데이터 파일 삭제 )
DROP TABLESPACE <테이블스페이스명> INCLUDING contents and datafiles;
```

### 2. Table Space의 종류

- **System Table Space**
    
    : 데이터베이스의 운영에 필요한 기본 정보를 담고 있는 **Data Dictionary Table 이 저장되는 공간**
    
    <aside>
    💡 **Dictionary ?**
    오라클 서버의 모든 정보를 저장하고 있는 아주 중요한 테이블이나 뷰를 의미 이 파일이 손상될 경우 DB 접근이 불가능해질 수 도 있으므로 일반 사용자 오브젝트는 저장하지 않는 것을 권장함
    
    </aside>
    
- **SYAUX Table Space**
    
    : System Table Space의 보조 역할로,  다양한 유틸리티 기능 및 Oracle 서버의 성능 튜닝을 위한 데이터들을 분리하여 저장한 공간
    
    문제가 발생하여도 시스템에는 문제 없지만 SYAUX가 제공하는 기능들은 사용 할 수 없게됨
    
- **Undo Tablespace**
    
    : 읽기 일관성을 유지하기 위해 사용되는 Table Space
    
    <aside>
    💡 데이터베이스에서 발생하는 수많은 DML 중 RollBack에 대비하여 수정 이전의 값에 대해 UNDO Segment에 저장하는데, 이것들을 관리하기 위한 공간으로 Undo Tablespace가 사용됨
    
    </aside>
    
    시스템을 운영할 때 적어도 하나의 Undo Tablespace를 필요로함
    
- Temporary Table Space
    
    : 데이터를 임시적으로 저장하는 공간으로 Oracle 재기동시 초기화되며 데이터 반입 및 반출시에도 사용
    
    사용자 쿼리의 요청으로 정렬하는 작업이 필요한 경우 **메모리에 부담을 덜어주기 위해 사용**
    
- General Table Space
    
    : 사용자의 필요에 의해서 만들어지는 Table Space로 DBA에 의해 자유롭게 조작됨 
    
    특별한 설정이 없다면, 사용자가 생성한 뷰 또는 테이블 같은 오브젝트들이 저장됨