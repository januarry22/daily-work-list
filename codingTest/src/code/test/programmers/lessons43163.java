package code.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * [프로그래머스] - 여행경로
 * */
public class lessons43163 {
    public static boolean[] visited;
    public static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

    public static int answer;


    public static void main(String[] args) {
        visited = new boolean[words.length];
        String begin="hit";
        String target="cog";

        dfs(begin, target, words, 0);

        System.out.println(answer);
    }
    public static void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }

        for(int i=0; i<words.length; i++){
            if(visited[i])
                continue;

            int check = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j))
                    check++;
            }

            if(check == begin.length()-1){
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
    }
//
//    public static void dfs(int index, String target, String[] words) {
//        answer++;
//        visit[index] = true;
//
//        System.out.print(words[index] + "->");
//        for (int i = 0; i < words.length; i++) {
//            if (!visit[i] && !words[index].equals(target)) {
//                visit[i] = true;
//                dfs(i, target, words);
//            }
//        }
//    }

}
