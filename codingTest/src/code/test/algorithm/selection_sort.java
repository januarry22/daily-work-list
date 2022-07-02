package code.test.algorithm;

import java.util.ArrayList;

/*
* JAVA 선택 정렬 selection sort
* */
public class selection_sort {
    public static void main(String[] args){
        int[] selection = {3, 5, 10, 1, 8, 7, 2, 4};


        for(int i = 0; i<selection.length-1;i++){
            int lowest = i;
            for(int j = i+1 ; j < selection.length; j++) {
                /*
                 * 최소값 찾을 때 까지 루프
                 */
                if(selection[lowest] > selection [j]) {
                     lowest = j;
                }
            }
            swap(selection, lowest, i);
        }

        for (int n : selection){
            System.out.print(n+"\n");
        }
    }

    public static void swap(int[] nonebubble, int prev, int next){

        int temp = nonebubble[prev];
        nonebubble[prev] = nonebubble[next];
        nonebubble[next] = temp;
    }
}
