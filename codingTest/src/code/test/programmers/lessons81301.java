package code.test.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lessons81301 {
    public static String test = "one4seveneight";

    public static void main(String[] args){
        Integer isCheck = solution(test);
        System.out.print("isCheck:::"+isCheck+"\n");
    }

    public static Integer solution(String s){

        String[] numArray = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<numArray.length; i++) {
            s = s.replace(numArray[i], Integer.toString(i));
        }
        System.out.print("s "+s);

        return Integer.parseInt(s);
    }

}
