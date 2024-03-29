package code.test.baekjoon.silver;

import java.io.*;
import java.util.Vector;

/*
 * 백준 - 대기업 승범이네
 *
 * */
public class problem17831 {
    static int N;
    static int[] person;
    static int[][] dp;
    static Vector<Integer>[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        person = new int[N + 1];
        v = new Vector[N + 1];
        dp = new int[N + 1][2];


        for (int i = 0; i <= N; i++)
            v[i] = new Vector<>();

        for (int i = 1; i <= N; i++)
            person[i] = Integer.parseInt(input[i - 1]);

        for (int i = 0; i < N - 1; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            v[a].add(b);
            v[b].add(a);
        }


        dfs(1, 0);

        bw.write(Math.max(dp[1][0], dp[1][1]) + "\n");
        bw.flush();


    }

    public static void dfs(int n, int parent) {


    }
}
