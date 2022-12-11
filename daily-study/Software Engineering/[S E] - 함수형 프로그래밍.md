# [S/E] - 함수형 프로그래밍

## 1. 함수형 프로그래밍 ?

- 순수 함수를 조합하고 소프트웨어를 만드는 방식

```html
❗ **프로그래밍 패러다임(Programming Paradigm)**
프로그래머에게 프로그래밍의 관점을 갖게 하고 코드를 어떻게 작성 할 것인지를 결정하게 하는 역할
새로운 방식을 갖게 하고 이를 바탕으로 코드를 작성할 수 있도록 도움

- 명령형 프로그래밍 : 무엇(What)을 할 것인지 보다 어떻게 (How)할 것인지를 설명하는 방식
	-> 절차지향 프로그래밍, 객체지향 프로그래밍
- 선언형 프로그래밍 : 어떻게 (How) 할것인지를 나타내기 보다 무엇(What)을 할것인지를 설명하는 방식
	-> 함수형 프로그래밍 
```

- 작은 문제를 해결하기 위한 함수를 작성하여 가독성을 높이고, 유지보수를 용이하게 함

## 2. 함수형 프로그래밍의 특징

- **부수 효과를 없애고 순수함수를 만들어 모듈화 수준을 높임**
    
    ✏️  **부수효과(Side Effect) : 다음과 같은 변화가 발생하는 작업을 의미**
    
     - 변수의 값이 변경됨
    
     - 자료 구조를 제자리에서 수정함
    
     - 객체의 필드값을 설정함
    
     - 예외나 오류가 발생하며 실행이 중단됨
    
     - 콘솔 또는 파일 I/O가 발생함
    
- **순수 함수 (Pure functions) : 위와 같은 Side Effect를 제거한 함수를 의미**
    
           - 반드시 하나 이상의 인자를 받고
    
     - 받은 인자를 처리해 반드시 결과물을 리턴함
    
     - 인자외의 다른 변수 사용 금지
    
    ```html
    ✔️ 순수 함수의 장점 
    - 함수 자체가 독립적이며 Side-Effect가 없기 때문에 Thread에 안전성을 보장
    - Thread에 안정성을 보장받아 병렬 처리를 동기화 없이 진행할 수 있음
    ```
    
- **1급 객체 (First-Class Object)** : 함수형 프로그래밍에서 함수는 1급 객체로 취급 되기 때문에 함수를 파라미터로 넘기는 작업이 가능함
    
     - 변수나 데이터 구조 안에 담을 수 있음
    
     - 파라미터로 전달
    
     - 반환값을 사용
    
     - 할당에서 사용한 이름과 무관하게 고유로 구별이 가능함
    

- **참조 투명성(Referential Transparency)**
    
     - 동일한 인자에 대해 항상 동일한 결과를 리턴 
    
     - 참조 투명성을 통해 기존 값은 변경되지 않고 유지된다.
    

## 3. Java 에서의 함수형 프로그래밍

- 람다식
- stream api
- 함수형 인터페이스

```html
private final List<String> words = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    @Test
    void wordProcessTest() {
        String result = words.stream()
                .filter(w -> w.length() > 1)
                .map(String::toUpperCase)
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining(" "));

        assertThat(result).isEqualTo("T H A N K");
    }
```

→ 무엇을 (What) 구현했는지 확인 가능