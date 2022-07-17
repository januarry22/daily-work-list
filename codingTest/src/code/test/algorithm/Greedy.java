package code.test.algorithm;

import java.util.*;

/*
 * JAVA 그리디 알고리즘
 * */
public class Greedy {
    public static void main(String[] args) {
        int[] arr = {500, 100, 50, 1};

        //coin(arr, 4720);

        int[][] arr2 = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};

        fractionalKnapsack(arr2, 30);
    }

    public static void coin(int[] arr, int total) {

        int total_coin_cnt = 0;

        List<Object> result = new ArrayList<>();

        for (int coin : arr) {
            Map<Integer, Integer> combi = new HashMap<>();
            int coin_cnt = total / coin;
            total_coin_cnt += coin_cnt;
            total -= coin * coin_cnt;

            combi.put(coin, coin_cnt);
            result.add(combi);
        }

        System.out.println(result.toString());
        System.out.println("동전의 개수 :   " + total_coin_cnt);
    }

    public static void fractionalKnapsack(int[][] arr, int capacity) {

        float total_value = 0;

        List<Object> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            Map<Object, Object> combi = new HashMap<>();
            // capacity 의 값이 0보다 클 때까지만 실행
            if (capacity > 0) {
                if (capacity - arr[i][0] >= 0) {
                    capacity -= arr[i][0];
                    total_value += arr[i][1];
                    combi.put(arr[i][0], 1);
                } else {
                    // 부분만 배낭에 넣을 수 있으므로 쪼개서 넣음
                    double fraction = (double) capacity / (double) arr[i][0];
                    capacity -= arr[i][0];
                    total_value += arr[i][1] * fraction;
                    combi.put(arr[i][0], fraction);
                }
            }
            result.add(combi);
        }

        System.out.println(result.toString());
        System.out.println(total_value);

    }


}
