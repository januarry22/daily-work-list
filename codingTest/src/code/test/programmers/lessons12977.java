package code.test.programmers;

/*
* [프로그래머스] - 없는 숫자 더하기
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
        for (int i=0; i < nums.length; i++){
            answer = nums[i] + nums[i+1] + nums[i+2];
            if(answer%2==0){
                flag ++;
            }
        }
        return flag;
    }
}
