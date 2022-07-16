package code.test.algorithm;

import java.util.*;

/*
 * JAVA 그리디 알고리즘
 * */
public class Greedy {
    public static void main(String[] args) {
        int[] arr = {500, 100, 50, 1};

        coin(arr, 4720);

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
        System.out.println("동전의 개수 :   "+total_coin_cnt);


    }


}
