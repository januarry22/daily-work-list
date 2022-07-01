# [프로그래머스]-나누어떨어지는 숫자배열

### **문제 설명**

array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

### 제한사항

- arr은 자연수를 담은 배열입니다.
- 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
- divisor는 자연수입니다.
- array는 길이 1 이상인 배열입니다.

```jsx
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int count = 0;
        ArrayList<Integer> newarr = new ArrayList<Integer>(); 
        for (int i =0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                newarr.add(arr[i]);
                count++;
            }
        }
        int[] answer = {};
        if (count > 0){
            answer = new int[newarr.size()];
            for(int j=0; j < newarr.size(); j++){
                answer[j] = newarr.get(j);
            }
        }else{
            answer = new int[]{-1};
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
```

→ 나누어 떨어지는 배열의 요소가 있으면 새로운 리스트에 넣고 count 증가

→ 없는 요소는 -1을 담아 리턴