# [백준] - The candy war

## [문제]

[9037번: The candy war](https://www.acmicpc.net/problem/9037)

## [구현]

```jsx
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 - The candy war
 *
 * */
public class problem9037 {
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int N = 5;
        int[] C = {2, 4, 7, 8, 9};
        C = circle(C, N, N);
    }
		
    public static int[] candy(int[] C){
        for (int i =0; i<C.length; i++){
            if (C[i] % 2 != 0){
                C[i]++;
            }
        }
        return C;
    }

    public static int[] circle(int[] C, int N, int len){
        int[] arr = new int[N];
        C = candy(C);
        System.out.println("회차::::"+cnt +"회차" );
        System.out.println(Arrays.toString(C));
        for (int i =0; i<N; i++){
            //[2, 4, 8, 8, 10]
            int mine = 0;
            int right =  0;
            if (i == 0){
                mine = C[i] / 2;
                right = C[N-1] / 2;
            }else{
                mine = C[i] / 2;
                right = C[i-1] / 2;
            }
            arr[i] = mine + right;
        }
        cnt++;
        System.out.println(Arrays.toString(arr));

        // 배열 중복 제거
        int[] carr = Arrays.stream(arr).distinct().toArray();
        len = carr.length;
        if(len==1){
            return arr;
        }
        return circle(arr, N, len);
    }
}
```

1. candy() 함수는 재귀 시작전에 모든 배열값이 홀수 일 경우 짝수로 만들어주는 작업을 수행
2. 배열 i 번째 수를 2로 나누어서 몫을 구하고, i-1 번째 수에서 2를 나눈 값을 더함
    1. 여기서, i ==0 이면 N-1 (배열 마지막 수 ) 를 가져와서 더해야함.
    2. 새로운 배열을 선언 (arr) 에 차례대로 입력
3. carr 은 arr에서 중복되는 요소를 제거한 배열
    1. carr 배열의 길이가 1이면, 모든 값이 동일 한 것을 의미함
4. 전역 변수 cnt 에 회차가 반복된 횟수를 더함

### [출력]

```jsx
회차::::0회차
[2, 4, 8, 8, 10]
[6, 3, 6, 8, 9]
회차::::1회차
[6, 4, 6, 8, 10]
[8, 5, 5, 7, 9]
회차::::2회차
[8, 6, 6, 8, 10]
[9, 7, 6, 7, 9]
회차::::3회차
[10, 8, 6, 8, 10]
[10, 9, 7, 7, 9]
회차::::4회차
[10, 10, 8, 8, 10]
[10, 10, 9, 8, 9]
회차::::5회차
[10, 10, 10, 8, 10]
[10, 10, 10, 9, 9]
회차::::6회차
[10, 10, 10, 10, 10]
[10, 10, 10, 10, 10]
```