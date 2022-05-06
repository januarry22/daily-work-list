package code.test.programmers;

/*
* [프로그래머스] - 음양더하기
* */
public class lessons76501 {
    public static int[] absolutes = {1,2,3};
    public static boolean[] signs = {true,false,true};



    public static void main(String[] args){
        int anwer = solution(absolutes,signs);
        System.out.print(anwer);
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer =0;


        for(int i=0;i<absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

}
