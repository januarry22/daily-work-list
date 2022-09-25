package code.test.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
 * [프로그래머스] - 게임 맵 최단거리
 * */
public class lessons1844 {

    public static void main(String[] args) {

        int[][] maps = {
                { 1, 0, 1, 1, 1},
                { 1, 0, 1, 0, 1},
                { 1, 0, 1, 1, 1},
                { 1, 1, 1, 0, 1},
                { 0, 0, 0, 0, 1}
        };

        System.out.println(solution(maps));

        System.out.println(solution(maps));
    }


    public static int solution(int[][] maps) {

        for(int[] map : maps){
            for(int i=0; i<map.length; i++){
                System.out.println(maps[i][i]);
            }
        }

        return 0;
    }
}
