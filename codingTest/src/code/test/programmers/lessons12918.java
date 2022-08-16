package code.test.programmers;

/*
 * [프로그래머스]
 * */
public class lessons12918 {
    public static int result = 0;
    public static int cnt = 0;

    public static void main(String[] args) {
        boolean answer = true;
        String s = "1234";

        if(s.length() == 4 || s.length() == 6){
            try{
                int x = Integer.parseInt(s);
                answer = true;
            } catch(NumberFormatException e){
                answer = false;
            }
        }

    }
}
