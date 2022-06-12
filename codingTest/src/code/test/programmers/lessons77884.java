package code.test.programmers;

/*
* [프로그래머스] - 약수의 개수와 덧셈
 * */
public class lessons77884 {
    public static int left = 13;
    public static int right = 17;

    public static void main(String[] args){
        int answer = solution(left,right);
            System.out.print(answer);
    }

    public static int solution(int left, int right) {
        int answer = 0;


        for(int i = left; i<=right; i++) {
            int serCnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    serCnt++;
                }
            }
            if(serCnt%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
        }
        return answer;
    }

}
