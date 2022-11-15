# [Java] - 람다식(Lambda Expression)

## 1. 람다식 (****Lambda Expression) ?****

- 함수를 하나의 식(expression) 으로 표현한 것
- 함수를 람다식 으로 표현하면 메소드의 이름이 필요 없기 때문에 , 익명함수(Anonymous Function)의 한종류라고 할 수 있음
- 메소드 이름은 사용하지않고, 컴파일러가 문맥을 살펴서 타입을 추론

<aside>
💡 익명함수(Anonymous Function) ?
- 이름이 없는 함수
- 일급 객체이므로 변수처럼 사용가능하며, 매겨변수로 전달이 가능

</aside>

### 람다식 기본 형태

```java
A a = (매개값) -> { 구현코드 };
```

## 2. 람다식 사용

**[장점]**

- 불필요한 코드를 줄이고, 가독성 높임
    - 기호 및 약속된 표현 사용
- 병렬처리, 함수적 프로그래밍에 유리
- 1급 객체이기 때문에 Stream API의 매개변수로 전달 가능

**[단점]**

- 람다식으로 만든 무명함수는 **재사용이 불가능**
- 람다를 남발하면 오히려 코드 복잡도가 증가
- 재귀로 사용하기에 부적합

## 3. 람다식 특징

- 람다식 내에서 사용되는 지역변수는 final이 붙지 않아도 상수로 간주됨
- 람다식으로 선언된 변수명은 다른 변수명과 중복 가능

### 함수형 인터페이스(Functional Interface)

<aside>
💡 **함수형 인터페이스 ?**
- 함수를 1급 객체처럼 다룰 수 있게 해주는 어노테이션
- 추상메서드가 1개만 정의된 인터페이스 
- 1개 뿐인 abstract 함수를 선언하고  **@FunctionalInterface**  어노테이션을 붙여줌

</aside>

- 람다식을 실행하면 인터페이스를 구현하는 객체가 생성
    - 익명구현객체
- 람다식은 함수적 인터페이스에서 사용

**함수형 인터페이스로 람다식 작성**

- 매개변수가 없고, 리턴값이 없는 람다식

```java
@FunctionalInterface
public interface lambdaEx {
     void lambdaEx();
}
public static void main(String[] args) {
        /* 1. 매개변수가 없고, 리턴값이 없는 람다식 */
        lambdaEx fc = () -> {
            System.out.println("CASE1");
            System.out.println("매개변수 X, 리턴값은 X");
            System.out.println("Hello lambda");
            System.out.println();
        };
        fc.lambdaEx();
}
```

- 매개변수가 있고, 리턴값이 없는 람다식

```java
@FunctionalInterface
public interface lambdaEx2 {
    void lambdaEx2(String str);
}

public static void main(String[] args) {
/* 2. 매개변수가 있고 , 리턴값이 없는 람다식 */
        lambdaEx2 fc2 = (str) ->{
            System.out.println("CASE2");
            System.out.println("매개변수 O, 리턴값은 X");
            System.out.println("입력"+str);
            System.out.println();
        };
        fc2.lambdaEx2("Java Programming");
}
```

- 매개변수가 없고, 리턴값이 있는 람다식

```java
@FunctionalInterface
    public interface lambdaEx3 {
        String lambdaEx3();
    }
public static void main(String[] args) {
    
        /* 3. 매개변수가 없고 , 리턴값이 있는 람다식 */
        lambdaEx3 fc3 = () ->{
            System.out.println("CASE3");
            System.out.println("매개변수 X, 리턴값은 O");
            return  "Java Programming";
        };

        System.out.println("출력"+fc3.lambdaEx3());
        System.out.println();

    }
```

- 매개변수가 있고, 리턴값이 있는 람다식

```java
 @FunctionalInterface
 public interface lambdaEx4 {
	  String lambdaEx4(String str);
 }
public static void main(String[] args) {
     
        /* 4. 매개변수가 있고 , 리턴값이 있는 람다식 */
        lambdaEx4 fc4 = (str) ->{
            System.out.println("CASE4");
            System.out.println("매개변수 O, 리턴값은 O");
            System.out.println("입력"+str);
            return  "OUT";
        };

        System.out.println("출력"+fc4.lambdaEx4("IN"));
        System.out.println();

    }
```

**Java 에서 제공 하는 함수형 인터페이스** 

| 종류 | 매개값 | 리턴값 | 메소드 형태 |
| --- | --- | --- | --- |
| Supplier<T> | X | O | void accept(T t) |
| Consumer<T> | O | X | T get() |
| Function<T, R> | O | O | R apply(T t) |
| Predicate<T> | O | O | R test(T t) |

- Supplier<T>
    
    
- Consumer<T>
- Function<T, R>
- Predicate<T>
