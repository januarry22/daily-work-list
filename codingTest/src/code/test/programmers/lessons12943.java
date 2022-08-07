package code.test.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
 * [프로그래머스] - 콜라츠 추측
 * */
public class lessons12943 {
    public static int result = 0;
    public static int cnt = 0;

    public static void main(String[] args) {

        int num = 626331;
        func(num);
//        while (num != 1) {
//            if (num % 2 == 0) {
//                num /= 2;
//            } else {
//                num = 3 * num + 1;
//            }
//            cnt++;
//            if (cnt == 500) {
//                cnt = -1;
//                break;
//            }
//        }
        System.out.println(cnt);

    }

    public static int func(int num) {
        long number = num;
        int answer;
        for(answer = 0; answer < 500; answer++){
            if(number == 1) return answer;
            else{
                if(number % 2 == 0) number /= 2;
                else number = number * 3 + 1;
            }
        }
        return -1;
    }
}
