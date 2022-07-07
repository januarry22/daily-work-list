# [프로그래머스] -  N개의 최소공배수

### **문제 설명**

두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

### 제한 사항

- arr은 길이 1이상, 15이하인 배열입니다.
- arr의 원소는 100 이하인 자연수입니다.

```jsx
class Solution {
    public static int solution(int[] arr) {
        
        int answer = arr[0];

        for (int i=1; i<arr.length; i++){
            int ucd = eucd(answer, arr[i]);
            answer = answer*arr[i] / ucd;
        }
        
        return answer;
    }
    
    public static int eucd(int a, int b) {
        int ucd = a % b;
        if(ucd ==0){
            return b;
        }else{
            return eucd(b, ucd);
        }
    }
    
}
```

1. 유클리드 호제법으로  최대 공약수를 구한다
2.  최소 공배수 = a, b / (최대공약수)
3. 배열의 마지막 원소까지 비교해서 최소공배수 구함

<aside>
💡 유클리드 호제법

두 가지 수에대해 최대공약수를 구하는 알고리즘

</aside>