# [프로그래머스] - 소수 만들기

### **문제 설명**

주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

### 제한사항

- nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
- nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

```bash
class Solution {
   public int solution(int[] nums) {
        int flag =0;

        for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length; j++){
                for(int k =j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(checkPrimeNum(sum)){
                        flag ++;
                    }
                }
            }
        }

        return flag;
    }
    public boolean checkPrimeNum(int sum){
        boolean checkNumTrue = true;
        if(sum==2){
            return checkNumTrue;
        }

        if(sum==1){
            checkNumTrue = false;
            return checkNumTrue;
        }
        for(int i = 2; i<sum; i++){
            if (sum%i == 0){
                // 나누어 떨어질 때 false
                checkNumTrue = false;
                break;
            }
        }
        return checkNumTrue;
    }
}
```