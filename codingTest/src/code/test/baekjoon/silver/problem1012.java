package code.test.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 백준 - 유기농배추
 *
 * */
public class problem1012 {
    // 가로
    public static int M;
    // 세로
    public static int N;

    public static int[][] ground;
    public static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            ground = new int[M][N];
            checked = new boolean[M][N];

            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[x][y] = 1;   //배추 좌표 입력
            }

        int count = 0;

        for(int j=0; j<M; j++){
            for(int k=0; k<N; k++){
                if(ground[j][k]==1 && !checked[j][k]){
                    //dfs(j,k);
                    bfs(j,k);
                    count++;
                }
            }
        }
        System.out.println(count);
        }
    }

    public static void dfs(int startX, int startY){
        checked[startX][startY]=true;

        int[] X = {0, 0, -1, +1};
        int[] Y = {-1, +1, 0, 0};

        for(int i=0; i<4; i++){
            int x = startX +X[i];
            int y = startY + Y[i];

            if(x<0 || x>=M||y<0|| y>=N){
                continue;
            }

            if(ground[x][y]==1 & !checked[x][y]){
                dfs(x,y);
            }
        }
    }

    public static void bfs(int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startX,startY});

        checked[startX][startY] =true;


        int[] X = {0, 0, -1, +1};
        int[] Y = {-1, +1, 0, 0};

        while (!queue.isEmpty()){
            int[] index = queue.poll();

            for(int i=0; i<4; i++){
                int x = index[0]+X[i];
                int y = index[1]+Y[i];
                if(x<0 || x>=M||y<0|| y>=N){
                    continue;
                }
                if(ground[x][y] ==1 & !checked[x][y]){
                    queue.offer(new int[]{x,y});
                    checked[x][y] =true;
                }

            }

        }



    }

}
