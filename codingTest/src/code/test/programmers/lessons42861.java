package code.test.programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * [프로그래머스] - 섬 연결하기
 * */
public class lessons42861 {
    public static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        /* union-find 알고리즘 사용 */
        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];

            queue.add(new Node(start, end, cost));
        }

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int start = temp.start;
            int end = temp.end;

            int a = find(start);
            int b = find(end);

            if (a == b) continue;

            union(start, end);

            answer += temp.cost;
        }
        System.out.println(answer);
        return answer;
    }

    public int find(int x) {
        if (x == parent[x])
            return x;
        return find(parent[x]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    public class Node implements Comparable<Node> {

        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }



    public void main(String[] args) {
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int n = 4;

        System.out.println(solution(n, costs));
    }

}
