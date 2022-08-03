package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] - 가장 큰 수
 * */
public class lessons42746 {

    public static void main(String[] args) {
       // int[] numbers = {20, 21, 11, 1, 0};
        int[] numbers = {6, 10, 2};

        String []str =new String[numbers.length];

        //문자열로 변경
        for(int i=0; i<numbers.length; i++){
            str[i]=String.valueOf(numbers[i]);
        }

        //문자열을 합쳤을 때  비교
        Arrays.sort(str, (a,b)->{
                    return (b+a).compareTo(a+b);
                }
        );
        // number 배열 안의 값을 10으로 나누었을대 나머지 순으로 정렬
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = 0; j < numbers.length - i - 1; j++) {
//                if (numbers[j] / 10 < numbers[j + 1] / 10) {
//                        swap(numbers, j, j + 1);
//                    System.out.println();
//
//                    if (numbers[j] / 10 < numbers[j + 1] % 10) {
//                        swap(numbers, j, j + 1);
//                    }
//                }
//            }
//        }


        String answer = "";
        for (String a : str) {
            answer += a;
        }
        if(answer.charAt(0)=='0') answer = "0";
        System.out.println(Arrays.toString(numbers));
        System.out.println(answer);

    }

//    public static void swap(int[] arr, int a, int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }
}
