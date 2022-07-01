# [프로그래머스] - 짝수와 홀수

### **문제 설명**

정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

### 제한 조건

- num은 int 범위의 정수입니다.
- 0은 짝수입니다.

```jsx
class Solution {
    public String solution(int num) {
        String[] answer = {"Even","Odd"};
        
        if(num % 2 == 0){
            return answer[0];
        }else{
	        return answer[1];
       }
        
    }
}
```

→ 나누어 떨어지면 짝수, 아니면 홀수로 판단해서 리턴함.