# [프로그래머스] - JadenCase 문자열 만들기

### **문제 설명**

JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

```java
class Solution {
    public String solution(String s) {
        String[] b = s.toLowerCase().split(" ");
        String answer = "";
        
       for (String first : b) {
            char ch = first.charAt(0);
            System.out.println("char ::" + ch);
            if (!Character.isUpperCase(ch)) {
                answer+=first.replace(first.charAt(0), Character.toUpperCase(ch))+" ";
            }
        }
		
        return  answer.stripTrailing();
    }
}
```

- 런타임 에러
- 공백 문자열 처리 방법이 문제

```java
class Solution {
    public String solution(String s) {
        String[] b = s.toLowerCase().split("");
        String answer = "";
        boolean isCase = true;
        
        for (String first : b) {
				answer += isCase? first.toUpperCase() : first;
				isCase = first.equals(" ")? true : false;
        }
		
        return  answer;
    }
}
```

- true / false 로 값을 구분해준뒤 젤마지막에 공백 오지않도록함