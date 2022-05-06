package code.test.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* [프로그래머스] - 없는 숫자 더하기
* */
public class lessons86051 {
    public static int[] numbers = {1,2,3,4,6,7,8,0};

    public static void main(String[] args){
        int anwer = solution(numbers);
        System.out.print(anwer);
    }

    public static int solution(int[] numbers) {
        int anwser =0+1+2+3+4+5+6+7+8+9;

        for(int num : numbers){
            anwser -= num;
        }

        return anwser;

    }

}
