package code.test.programmers;

/*
 * [프로그래머스]
 * */
public class lessons12981 {
    public static void main(String[] args) {

        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 3;

        System.out.println(solution(words, n));
    }

    public static int[] solution(String[] words, int n) {
        int[] answer = new int[2];

        // 첫글자, 끝글자 동일
        // 동일 단어 금지
        for (int i = 0; i < words.length; i++) {
            char a = words[i].charAt(words[i].length() - 1);
            for (int j = i + 1; j < words.length; j++) {
                char b = words[j].charAt(0);
                System.out.println(a+""+b);
                if (a != b) {
                }
                if (words[i] == words[j]) {
                    System.out.println((j + 1) / n);
                }
            }
        }


        return answer;
    }

}
