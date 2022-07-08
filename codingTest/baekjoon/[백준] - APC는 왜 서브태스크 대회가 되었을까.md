# [백준] - APC는 왜 서브태스크 대회가 되었을까?

```jsx
package code.test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 백준 - APC는 왜 서브태스크 대회가 되었을까?
 *
 * */
public class problem17224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] math = new int[N][N];
        for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int easy = Integer.parseInt(st.nextToken());
                int hard = Integer.parseInt(st.nextToken());
                math[i][0] = easy;
                math[i][1] = hard;
        }

//        int N = 4;
//        int L = 8;
//        int K = 4;
//        int[][] math = {{1, 8}, {4, 5}, {6, 20}, {9, 12}};

        int easy = 0;
        int hard = 0;

        for (int i = 0; i < N; i++) {
            if (math[i][1] <= L) {
                hard++;
            }
            else if (math[i][0] <= L) {
                easy++;
            }
        }

        int ans = Math.min(hard, K) * 140;

        if (hard < K) {
            ans += Math.min(K - hard, easy) * 100;
        }

        System.out.println(ans);
    }

}
```

1. 어려운 문제가 L 보다 작으면 hard(맞힌 어려운 문제 수 ) 를 +1
2. 쉬운 문제가 L 보다 작으면 easy (맞힌 쉬운 문제 수 ) 를 +1
3. 어려운 문제수에는 140을 곱해서 총점, 쉬운 문제수는 100을 곱해서 총점을 계산