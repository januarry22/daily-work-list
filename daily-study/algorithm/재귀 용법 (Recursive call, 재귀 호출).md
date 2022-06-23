# 재귀 용법 (Recursive call, 재귀 호출)

# 1. 재귀 용법 이란?

- 함수 안에서 동일한 함수를 호출하는 형태
- 알고리즘 문제 해결 전략

# 2. 재귀 함수의 일반적인 형태

```bash
public static int factorial1(int num){
        if (num > 1)
            return  num * factorial1(num-1);
        else
            return num;
}
```

## 재귀 호출은 스택의 전형적인 예

- 함수는 내부적으로 스택처럼 관리된다.

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcK6Xmv%2FbtqJWsEWi8H%2Fe1VeWZuLucF0sNjk83zFVk%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcK6Xmv%2FbtqJWsEWi8H%2Fe1VeWZuLucF0sNjk83zFVk%2Fimg.png)