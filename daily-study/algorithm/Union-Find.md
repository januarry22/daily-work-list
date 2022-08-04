# Union-Find

# 1.  Union-Find ?

- 대표적 그래프 알고리즘 (합집합 찾기)
- **상호 배타적 집합(Disjoint-set) 라고도함**
    
    <aside>
    💡 Disjoint Set ?
    - 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조
    - 공통 원소가 없는(서로소) 들로 이루어짐
    
    </aside>
    
- 여러 노드가 존재할 때, 두 노드를 선택해서 현재 두 노드가 같은 그래프에 속하는지 판별하거나 서로 연결할 때 사용하는 알고리즘
    
    <aside>
    💡 Union-Find 연산
    - **Union** 
            두 개별 집합을 하나의 집합으로 합침. 두 트리를 하나의 트리로 만듬
    - **Find**
             여러 노드가 존재할 때, 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는지 판별하기 위해, 각 그룹의 최상단 원소 (즉, 루트 노드)를 확인
    
    </aside>
    

### 서로소 집합

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fn2ETn%2FbtqVyUcVDLH%2FN2cmigIFkf7puiJ578KY11%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fn2ETn%2FbtqVyUcVDLH%2FN2cmigIFkf7puiJ578KY11%2Fimg.png)

- 각각 원소들은 자기 자신만을 가리킴
- p[i] (부모노드) = i (노드번호)

### **Union-Find 수행**

- **Union(1,2), Union(3,4)**
    - 일반적으로 부모노드가 작을 쪽으로 합쳐짐
    - 2번 노드는 1을, 4번 노드는 3으로 연결

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbIY21k%2FbtqVAIJQ1Fx%2F4tp9QFtxlYGohxOYFvgsEk%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbIY21k%2FbtqVAIJQ1Fx%2F4tp9QFtxlYGohxOYFvgsEk%2Fimg.png)

- **1, 2, 3 이 연결 되어있을 경우**
    - 2번 노드는 1을 가리키고, 3번 노드는 2를 부모노드로 하고있기 때문에, 1과 3이 연결 되어있는지 파악하기 어려움

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbHCIx8%2FbtqVAIJQ1EN%2FKTnHVzlYguRYZQgQwSz6vk%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbHCIx8%2FbtqVAIJQ1EN%2FKTnHVzlYguRYZQgQwSz6vk%2Fimg.png)

- 3의 부모노드인 2를 찾음
- 2의 부모노드인 1을 찾음
- **이 과정(Find)을 재귀적으로 반복**해 더 작은 원소를 root로 설정
    - 3번 노드의 부모노드를 1로 변경
    - 오른쪽과 같이 그래프나타냄
    

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FtfxaG%2FbtqVnYOIgcS%2FKTKkmgKMAWk9Cp8fn2W4A0%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FtfxaG%2FbtqVnYOIgcS%2FKTKkmgKMAWk9Cp8fn2W4A0%2Fimg.png)

- 최종적인 집합의 형태
    - { 1, 2, 3 } ,{4}, {5}, {6}, {7}, {8}

# 2. Java 코드

```java

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
				// true
        System.out.println("1과 4은 연결되어 있나요? " + isSameParent(1, 4));
				// false
    }

}
```