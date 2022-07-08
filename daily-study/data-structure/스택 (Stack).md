# 스택 (Stack)

# **스택 (Stack)**

- 데이터를 제한적으로 접근할 수 있는 구조
    - 한쪽 끝에서만 자료를 넣거나 뺄 수 있는 구조 (LIFO
- 가장 나중에 쌓은 데이터를 가장 먼저 빼낼 수 있는 데이터 구조

## **1. 스택 구조**

```
- 스택은 LIFO(Last In, First Out) 또는 FILO(First In, Last Out) 데이터 관리 방식을 따름
    - LIFO : 마지막에 넣은 데이터를 가장 먼저 추출
    - FILO : 처음에 넣은 데이터를 가장 마지막에 추출
- 대표적인 스택의 활용
    - 컴퓨터 내부의 프로세스 구조의 함수 동작 방식
- 주요기능
    - push() : 데이터를 스택에 넣기
    - pop() : 데이터를 스택에서 꺼내기
```

### 2. 스택 구조와 프로세스 스택

- 스택 구조는 프로세스 실행 구조의 가장 기본
    - 함수 호출시 프로세스 실행 구조를 스택과 비교해서 이해 필요
    

### 3. 구현

```jsx

import java.util.Stack;

/*
* JAVA 배열
* */
public class stack {
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();

        stack.push("itme::1");
        stack.push("itme::2");
        stack.push("itme::3");

        System.out.println(stack);

        System.out.println(stack.peek());   
				// stack 최상단 값 -> item3

        System.out.println(stack.pop());   
				// stack 최상단 값이 꺼내짐 -> item3
        
        System.out.println(stack.peek());   
				// item3이 pop()되었으므로 item2가 peek가 됨.

    }

}
```

### 4. 스택의 장단점

```
- 장점
    - 구조가 단순해서, 구현이 쉽다.
    - 데이터 저장 /읽기 속도가 빠르다.
- 단점 (일반적인 스택 구현시)
    - 데이터 최대 갯수를 미리 정해야한다.
		- 미리 최대 공간을 확보해야함
```