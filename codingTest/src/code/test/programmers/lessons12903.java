package code.test.programmers;

/*
 * [프로그래머스]
 * */
public class lessons12903 {
    public static void main(String[] args) {

        String s ="qwer";

        String a = String.valueOf(s.charAt(s.length()/2));
        String b = String.valueOf(s.charAt(s.length()/2-1));

        if(s.length() % 2 == 0){
            s = b +a;
        }

        System.out.println(a);
    }

}
