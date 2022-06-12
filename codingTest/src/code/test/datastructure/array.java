package code.test.datastructure;

import java.util.Arrays;

/*
* JAVA 배열
* */
public class array {
    public static void main(String[] args){
        int[] arrays = new int[3];

        System.out.print("배열의 사이즈 "+arrays.length);

        for(int i : arrays){
            System.out.print("배열 데이터"+i);

        }
    }

}
