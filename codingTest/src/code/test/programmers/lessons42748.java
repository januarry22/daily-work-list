package code.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* [프로그래머스] - K번쨰 수
* */
public class lessons42748 {
    public static int[] array = {1, 5, 2, 6, 3, 7, 4};
    public static int[][] commands={{2, 5, 3},{4, 4, 1}, {1, 7, 3}};

    public static void main(String[] args){
        int[] answer = solution(array, commands);
        for(int a : answer){
            System.out.print(a);
        }
    }

    public static int[] solution(int[] array,int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length;i++){
                int n1 = commands[i][0];
                int n2 = commands[i][1];
                int n3 = commands[i][2];
                int[] splitarray = Arrays.copyOfRange(array,n1-1,n2);
                Arrays.sort(splitarray);
                System.out.print("j"+splitarray[n3-1]+"\n");
                answer[i] = splitarray[n3-1];
        }


        return answer;
    }

}
