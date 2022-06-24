# 동적 계획법 (Dynamic Programming)과 분할 정복 (Divide and Conquer)

## 1. 정의

- 동적계획법
    - 입력 크기가 작은 부분 문제들을 해결한 후, 해당 부분 문제의 해를 활용해서, 보다 큰 크기의 부분 문제를 해결, 최종적으로 전체 문제를 해결하는 알고리즘
    - 상향식 접근법으로, 가장 최하위 해답을 구한 후, 이를 저장하고, 해당 결과값을 이용해서 상위 문제를 풀어가는 방식
    - Memorization 기법을 사용함
    : Memorization이란 프로그램 실행 시 이전에 계산한 값을 저장하여, 다시 계산하지 않도록 하며 전체 실행 속도를 빠르게 하는 기술
    - 문제를 잘게 쪼갤 때, 부분 문제는 중복되어 , 재활용됨
- 분할 정복
    - 문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘
    - 하향식 접근법으로, 상위의 해답을 구하기 위해, 아래로 내려가면서 하위의 해답을 구하는 방식
    - 문제를 잘개 쪼갤때, 부분 문제는 서로 중복되지 않음

## 2. 공통점과 차이점

- 공통점 : 문제를 잘게 쪼개서, 가장 작은 단위로 분할
- 차이점
    - 동적계획법 : 부분 문제는 중복되어, 상위 문제 해결 시 재활용됨
    Memorization기법 사용
    (부분 문제의 해답을 저장해서 재활용하는 최적화 기법으로 사용)
    - 분할 정복 : 부분 문제는 서로 중복되지 않음
    Memorization기법 사용 안함

## 3. 동적계획법 알고리즘 이해

<aside>
💡 ****DP 문제 성립 조건****

- **최적 부분 구조(Optimal Substructure)**
    
    : 상위 문제를 하위 문제로 나눌 수 있으며 하위 문제의 답을 모아서 상위 문제를 해결할 수 있다.
    
- **중복되는 부분 문제(Overlapping Subproblem)**
    
    :  동일한 작은 문제를 반복적으로 해결해야 한다.
    
    ex) 피보나치 수열
    
</aside>

### 피보나치 수열

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F0YRl3%2FbtrhKLlr9QX%2FeKlwtKaAqMogyl0zI0LOZk%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F0YRl3%2FbtrhKLlr9QX%2FeKlwtKaAqMogyl0zI0LOZk%2Fimg.png)

→ 점화식 : F(n) = F(n-1) + F(n-2)

- 재귀함수로 구현

```bash
static int fibo(int x) {
	  if (x<=1)
         return x;
   return fibo(x-1) + fibo(x-2);
}
```

→  f(5)의 값을 구하기 위해 f(4)와 f(3)의 값을 알아야 한다. 마찬가지로, f(4)의 값을 구하기 위해 f(3)과 f(2)의 값을 알아야함.

 **N이 작은 함수 호출로 갈수록 그 호출의 횟수가 점점 증가**

→ **시간복잡도 O(2^n)**

- 동적 계획법 ( 하향식 )
    - 상위 문제를 해결하기 위해서 하위 문제를 재귀적으로 호출하여 상위 문제를 해결하는 방식
    - 이때 해결한 하위 문제를 저장 하기 위해 Memoization이 사용됨

```bash
static int dp_Topdow(int x) {
        if (x<=1)
            return x;
        if(dp[x] != 0) return dp[x];
        dp[x] = fibo(x-1) + fibo(x-2);
        return dp[x];
}
```

- 동적 계획법 ( 상향식 )
    - 하위에서부터 문제를 해결해나가면서 먼저 계산했던 문제들의 값을 활용해서 상위 문제를 해결

```bash
static int dp_Bottomup(int x) {
        dp[1] =1;
        dp[2] =2;
        for(int i=3; i<x+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[x];
}
```