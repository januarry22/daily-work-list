package code.test.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * [프로그래머스]
 * */
public class lessons12981 {
    public static void main(String[] args) {

        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 3;

        System.out.println(Arrays.toString(solution(words, n)));
    }

    public static int[] solution(String[] words, int n) {
        int[] answer = new int[2];

        // 첫글자, 끝글자 동일
        // 동일 단어 금지

        int gameCount = 1;
        int peopleCount = 0;
        String prev = "";
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            String now = words[i];
            peopleCount++;

            if(i > 0){
                //끝말 확인, 이미 존재하는 단어인지 확인
                char prevChar = prev.charAt(prev.length()-1);
                char nowChar = now.charAt(0);
                if(prevChar != nowChar || map.containsKey(now)){
                    answer[0] = peopleCount;
                    answer[1] = gameCount;
                    break;
                }

            }

            map.put(now, 0);
            prev = now;

            if(peopleCount == n){
                peopleCount = 0;
                gameCount ++;
            }
        }


        return answer;
    }

}
