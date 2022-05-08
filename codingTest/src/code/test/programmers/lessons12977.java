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
        int answer = 0;

        int flag =0;

        for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length; j++){
                for(int k =j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum % sum ==1){
                        System.out.print("nums sum " + sum + "\n");
                        flag ++;
                    }
                }
            }
        }
        return flag;
    }
}
