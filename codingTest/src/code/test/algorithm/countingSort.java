package code.test.algorithm;

import java.util.Arrays;

/*
 * JAVA radix sort
 * */
public class countingSort {
    public static void main(String[] args) {
        int[] arr = {11, 5, 35, 39, 21, 49, 12, 38};

        int[] counting = new int[50];
        int[] result = new int[8];


        // 1 : arr 의 value 값을 index 로 하는 counting 배열 값 1 증가
        for(int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        // 2 : counting 배열 누적합
        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 3:  counting 배열의 값을 인덱스로 하여 result에 value 값을 저장
        for(int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            counting[value]--;
            result[counting[value]] = value;
        }


        System.out.println(" * 초기 배열 : arr");
        System.out.println(Arrays.toString(arr));
        System.out.println();


        System.out.println(" * counting 배열 ");
        for(int i = 0; i < counting.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.print("[  "+ i  +" ]\t");
            System.out.print( counting[i] + "\t");
        }
        System.out.println();



        System.out.println();

        System.out.println("* 정렬 후 : result");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

}
