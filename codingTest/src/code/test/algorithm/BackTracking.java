package code.test.algorithm;

import java.util.Stack;

/*
 * JAVA 백트래킹
 *
 * */
public class BackTracking {

    static int N = 4;
    static int[][] board = new int[4][4];

    public static void main(String[] args) {

        if(queen(0)==false){
            System.out.println("not exist");
        }else{
            for(int i=0;i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.println(board[i][j]+" ,");
                }
                System.out.println();
            }
        }
    }
    private static boolean queen(int col){

        if(col>=N){
            return true;
        }

        for(int i=0;i<N; i++){
            if(check(i,col)==true){
                board[i][col] =1;

                if(queen(col+1)==true){
                    return true;
                }

                board[i][col]=0;
            }
        }
        return true;
    }

    private static boolean check(int row, int col){
        int i, j;

        // 현재 행의 모든 열에 퀸이 있는지 테스트
        for(i=0; i<col; i++){
            if(board[row][i]==1){
                return false;
            }
        }

        // 현재 위치의 좌상단 대각선으로 퀸이 있는지 테스트
        for(i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][i] == 1){
                return false;
            }
        }

        // 현재 위치의 우하단 대각선으로 퀸이 있는지 테스트
        for(i = row, j = col; i < N && j >= 0; i++, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
