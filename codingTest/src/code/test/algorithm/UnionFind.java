package code.test.algorithm;

/*
 * JAVA UnionFind
 * */
public class UnionFind {
    public static int[] parent = new int[1000001];

    // x가 포함되어 있는 집합 확인
    public static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    // 두 개별 집합을 하나로 합침
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        // 같은 부모를 가지고 있지 않을 때
        if (x != y) {
            parent[y] = x;
        }
    }

    // 현재 두 노드가 서로 같은 그래프인지 확인. 최상단(root)확인
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        // 1 2 3 4 5 6 7 8
        for (int i = 1; i <= 8; i++) {
            parent[i] = i;
        }
        // {1,2},{3},{4}, {5}, {6}, {7}, {8}
        union(1, 2);
        // {1,2,3} ,{4}, {5}, {6}, {7}, {8}
        union(2, 3);
        System.out.println("1과 3은 연결되어 있나요? " + isSameParent(1, 3));
        System.out.println("1과 4은 연결되어 있나요? " + isSameParent(1, 4));
    }

}
