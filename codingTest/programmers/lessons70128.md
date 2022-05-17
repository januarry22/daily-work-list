# [프로그래머스] - 내적

### **문제 설명**

길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 [내적](https://en.wikipedia.org/wiki/Dot_product)을 return 하도록 solution 함수를 완성해주세요.

이때, a와 b의 내적은 `a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]` 입니다. (n은 a, b의 길이)

---

### 제한사항

- a, b의 길이는 1 이상 1,000 이하입니다.
- a, b의 모든 수는 -1,000 이상 1,000 이하입니다.

---

### 풀이

```bash
public int solution(int[] a,int[] b) {
        int answer =0;
        int arrayLength = (a.length + b.length) / 2;

        for(int i=0; i<arrayLength;i++){
            answer += a[i] * b[i];
        }

        return answer;
    }
```

- 길이가 같은 두 배열이기 때문에 나누기 2를 통해 길이 검증
- 각각 i 번째 인덱스 값을 가져와 곱한후 더하기