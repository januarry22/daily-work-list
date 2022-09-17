package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] - 등교길
 * */
public class lessons42898 {

    /* 최단경로의 개수 1,000,000,007 로 나눔 */
    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};
        int m = 4;
        int n = 3;
        System.out.println(solution(n, m, puddles));

    }

    public static int solution(int n, int m, int[][] puddles) {

        int answer = 0;
        int DEVIDE = 1000000007;
        int[][] route = new int[n][m];

        route[0][0] = 1;

        /* 물 웅덩이 좌표 : -1 */
        for (int[] puddle : puddles) {
            route[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (route[i][j] == -1) {
                    route[i][j] = 0;
                    continue;
                }

                /* 맨 위가 아니면 */
                if (i != 0) {
                    route[i][j] += route[i - 1][j] % DEVIDE;
                }
                /* 맨 아래가 아니면 */
                if (j != 0) {
                    route[i][j] += route[i][j - 1] % DEVIDE;
                }
            }
        }
        System.out.println(Arrays.toString(route[0]));
        System.out.println(Arrays.toString(route[1]));
        System.out.println(Arrays.toString(route[2]));

        answer = route[n - 1][m - 1] % DEVIDE;

        return answer;
    }


}
