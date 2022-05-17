package code.test.programmers;

/*
* [프로그래머스] - 소수 만들기
* */
public class lessons12977 {
    public static int[] nums = {1,2,3,4};

    public static void main(String[] args){
        int answer = solution(nums);
        System.out.print(answer);
    }

    public static int solution(int[] nums) {
        int flag =0;

        for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length; j++){
                for(int k =j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    System.out.print("sum " + sum + "\n");
                    System.out.print("checkPrimeNum(sum) " + checkPrimeNum(sum) + "\n");
                    if(checkPrimeNum(sum)){
                        flag ++;
                    }
                }
            }
        }

        System.out.print("nums flag " + flag + "\n");
        return flag;
    }
    public static boolean checkPrimeNum(int sum){
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
