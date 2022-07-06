package code.test.baekjoon;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 백준 - 이름궁합 테스트
 * */
public class problem17269 {
    public static int answer1 = 0;
    public static int answer2 = 0;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] wait = new int[N];
//        for(int i = 0; i < N; i++) {
//            wait[i] = sc.nextInt();
//        }
        int[] alp = {
                3, 2,	1,	2,	4,	3,	1,	3,	1,	1,	3,	1,	3,	2,	1,	2,	2,	2,	1,	2,	1,	1,	1,	2,	2,	1
        };

        int N = 3;
        int M = 2;

        String A = "BOJ";
        String B = "IN";

        int min_len = N-M;
        String reserve = "";
        if(min_len<0){
            min_len = N;
            reserve = B.substring(N, M);
        }else{
            min_len = M;
            reserve = A.substring(M, N);
        }


        String combi = "";
        for(int i=0; i<min_len; i++){
            combi += String.valueOf(A.charAt(i)) + String.valueOf(B.charAt(i));
        }
        combi += reserve;

        int[] strAlp = new int[N+M];
        for (int i = 0; i < combi.length(); i++){
            strAlp[i] = alp[combi.charAt(i) - 'A'];
        }

        dfs(strAlp, true);

        if(answer1<=0){
            System.out.println(answer2+"%");
        }else{
            System.out.println(answer1+""+answer2+"%");
        }
    }


    public static void dfs(int[] vals, boolean flag) {
        if(flag && vals.length > 2){
            flag = true;
            int[] tmp = new int[vals.length - 1];
            for (int i = 0; i < vals.length - 1; i++) {
                tmp[i] = vals[i] + vals[i + 1];
                if (tmp[i] > 0 && tmp[i] >= 10){
                    tmp[i] = tmp[i] - 10;
                }
            }
            dfs(tmp, flag);
        }else {
            answer1 = vals[0];
            answer2 = vals[1];
            flag = false;
            return;
        }
    }

}
