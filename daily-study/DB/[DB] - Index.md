# [DB] - Index

## 1. Index 란?

- 추가적인 쓰기 작업과 저장 공간을 활용하여 데이터베이스 테이블의 검색속도를 향상시키기 위한 자료구조
- 특정 테이블과 데이터를 색인화 하여 탐색 하기 때문에 검색에 효율적임

## 2. Index의 특징

```html
특정 컬럼에 Index를 생성하면, 해당 컬럼의 데이터들을 정렬하여 별도의 메모리 공간에 데이터의
물리적 주소와 함께 저장되고 *옵티마이저에서 판단하여 인덱스에 접근하게되고 해당 인덱스에 저장되어있는 
데이터의 물리적 주소로 가서 데이터를 가져오는 식으로 동작하여 검색 속도를 향상시킴

* 옵티마이저 : 옵티마이저는 가장 효율적인 방법으로 SQL을 수행할 최적의 처리 경로를 생성해주는 
						DBMS의 핵심 엔진
```

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcQi8RP%2Fbtq8BkRrRfb%2Fa5C0jH5pfSA2KKz7C9fB7k%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcQi8RP%2Fbtq8BkRrRfb%2Fa5C0jH5pfSA2KKz7C9fB7k%2Fimg.png)

- 데이터가 정렬되어 있는 있으므로, 조건검색에 유리하지만 반대로 정렬 상태를 유지 시켜야 효율적인 수행이 가능
- 데이터의 양이 증가할수록 실행 속도는 느려지고, JOIN이나 서브 쿼리 사용 시 곱 연산이 일어나 데이터 양이 증가하기 때문에 Index를 적절하게 사용
- 테이블을 조회하는 속도와 그에 따른 성능을 향상시킬 수 있음
- 전반적인 시스템의 부하를 줄일 수 있음

### Index 의 장점

- **조건 검색 WHERE 절의 효율성**

일반적으로 쿼리문 사용시 WHERE 조건절에 맞는 데이터를 찾아낼 때 Full Table Scan을 사용하면 

레코드의 처음부터 끝까지 다 읽어서 검색 조건과 맞는지 비교함.

하지만, **인덱스 테이블 스캔(Index Table Scan) 시** 인덱스 테이블은 데이터들이 정렬되어 저장되어 있기때문에 해당 조건**(WHERE)**에 맞는 데이터를 빠르게 찾아 낼 수 있음.

- **정렬 ORDER BY 절의 효율성**

ORDER BY 는 정렬과 동시에 1차적으로 메모리에서 정렬이 이루어지고 메모리보다 큰 작업이 필요하다면 

추가적인 디스크 I/O 도 발생하게 되는데 이러한 정렬 과정없이도 데이터가 이미 정렬되어 있어 추가적인 

자원을 소모 하지 않고도 정렬된 데이터를 가져올 수 있음

- **MIN, MAX의 효율적인 처리가 가능**

정렬된 데이터에서 MIN값과 MAX값을 레코드의 시작 값과 끝 값 한 건씩만 가져오면 되기 때문에 Full Table Scan으로 테이블을 탐색 하는 것보다 효율적임

### Index 의 단점

- ****인덱스는 DML(변경)에 취약****

DML을 통한 데이터 변경시 **다시 인덱스 테이블을 정렬** 시켜야하므로 DML이 빈번한 테이블 보다 검색을 위주로 하는 테이블에 생성 시키는 것이 좋음

이때 인덱스 테이블, 원본 테이블 두군데의 데이터 수정 작업을 해주어야하는 단점

- ****인덱스가 무조건 좋은 것은 아니다****

검색시 **테이블의 전체 데이터 중 10~ 15%이하의 데이터**를 처리하는 경우에만 효율적이고 그이상의 데이터를 처리시에는 사용하지 않는 것이 효율적

- 속도 향상을 위해 ****인덱스를 많이 만드는 것은 좋지 않음****

인덱스 관리하기 위해 데이터베이스 저장공간의 약 10%에 해당하는 추가적인 저장공간이 필요함

조회 성능을 극대화 하기 위해 사용하지만 너무 많은 인덱스를 사용하게 되면 결국 데이터베이스 성능을 저하 시킴.

## 3.  Index 의 관리

- DML 발생시 추가 적인 정렬작업에 대한 부하를 최소화 하기 위해 '데이터 삭제'라는 개념에서 '인덱스를 사용하지 않는다'라는 작업으로 이를 대신함

```html
- INSERT : 새로운 데이터에 대한 인덱스를 추가한다.
- DELETE : 삭제하는 데이터의 인덱스를 사용하지 않는다는 작업을 진행한다.
- UPDATE : 기존의 인덱스를 사용하지 않음 처리하고, 갱신된 데이터에 대해 인덱스를 추가한다.
```

## 4. Index 생성 전략

1. 규모가 작지 않은 테이블 (검색을 위한 테이블)
2. DML이 빈번하지 않은 컬럼
3. 항상 = 으로 비교되는 컬럼
4. 중복되는 데이터가 최소한인 컬럼 (분포도가 좋은 컬럼)
5. JOIN이나 WHERE 또는 ORDER BY 절에서 자주 사용되는 컬럼

## 5. Index의 자료구조

- 가장 많이 사용 되는 B TREE의  **B * TREE와 B + TREE 구조, 해시테이블 등이 있음**

### ****[ 해시 테이블(Hash Table) ]****

- 해시 테이블은 (Key, Value)로 데이터를 저장하는 자료구조 중 하나로 빠른 데이터 검색이 필요할 때 유용하다.
- **해시 테이블은 Key값을 이용해 고유한 index를 생성(데이터=컬럼의 값, 데이터의 위치)를 (Key, Value)로 사용**하여 그 index에 저장된 값을 꺼내오는 구조
- 시간복잡도 : **O(1)**
- 해시 함수는 값이 1이라도 달라지면 완전히 다른 해시값을 생성하므로, **등호(=)연산에만 특화 되어있어 부등호 연산(>,<)이 자주 사용되는 데이터베이스 검색을 위해서는 적합하지 않음**

### ****[ B+Tree ]****

- B+Tree는 DB의 인덱스를 위해 자식 노드가 2개 이상인 B TREE를 개선시킨 자료구조
- 시간 복잡도 : O(𝑙𝑜𝑔2𝑛log2n)

```html
- 리프노드(데이터노드)만 인덱스와 함께 데이터(Value)를 가지고 있고, 나머지 노드(인덱스노드)들은 
	데이터를 위한 인덱스(Key)만을 갖는다.
- 리프노드들은 LinkedList로 연결되어 있다.
- 데이터 노드 크기는 인덱스 노드의 크기와 같지 않아도 된다.
```

- BTree의 리프노드들을 LinkedList로 연결하여 순차검색을 용이하게 하는 등 **BTree를 인덱스에 맞게 최적화**
- 부등호를 이용한 순차 검색 연산이 자주 발생 할 수 있는 데이터베이스에서 해시 테이블 보다 인덱싱에 적합한 자료구조

### ****[ B*Tree ]****

- 대부분의 DBMS 그리고 오라클에서 특히 중점적으로 사용되고 있는 보편적인 인덱스
- Root(기준) / Branch(중간) / Leaf(말단) Node로 구성된 계층적 구조

```html
특정 컬럼에 인덱스를 생성하는 순간 컬럼의 값들을 정렬하는데, 오라클 서버에서 풀 스캔보다 
인덱스 스캔이 유리하다고 판단되었을 때 생성된 인덱스의 정렬한 순서가 중간쯤 되는 데이터를
 뿌리에 해당하는 ROOT 블록으로 지정하고 ROOT 블록을 기준으로 가지가 되는 BRANCH블록을 
정의하며 마지막으로 잎에 해당하는 LEAF 블록에 인덱스의 키가 되는 데이터와 데이터의 
물리적 주소 정보인 ROWID를 저장
```