package code.test.programmers;

/*
* [프로그래머스] - 내적
* */
public class lessons70128 {
    public static int[] a = {1,2,3,4};
    public static int[] b = {-3,-1,0,2};

    public static void main(String[] args){
        int answer = solution(a, b);
        System.out.print(answer);
    }

    public static int solution(int[] a,int[] b) {
        int answer =0;
        int arrayLength = (a.length + b.length) / 2;

        for(int i=0; i<arrayLength;i++){
            answer += a[i] * b[i];
        }

        return answer;
    }

}
