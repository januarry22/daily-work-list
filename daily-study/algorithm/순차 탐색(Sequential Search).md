# 순차 탐색(Sequential Search)

# 1. 순차 탐색(Sequential Search) 이란?

- 탐색은 여러 데이터 중에서 원하는 데이이터를 찾아내는 것을 의미
- 데이터가 담겨있는 리스트를 앞에서부터 하나씩 비교해서 원하는 데이터를 찾는 방법

# 2. 알고리즘 구현

```bash
public class sequen_search {
    public static int[] arr = {5, 2, 3, 1, 9, 11, 15, 16, 33, 23};
    public static void main(String[] args){

        System.out.print("index :"+  sequenSearch(15));
        System.out.print("not in index :"+  sequenSearch(18));
    }

    static int sequenSearch(int key) {

        for(int i = 0; i<arr.length; i++){
            if (key == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
```

# 3. 알고리즘 분석

- 최악의 경우 리스트 길이가 n일때, n번 비교해야함
    - O(n)