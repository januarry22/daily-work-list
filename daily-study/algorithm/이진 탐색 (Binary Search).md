# 이진 탐색 (Binary Search)

# 1. 이진 탐색(Binary Search) 이란?

- 탐색할 자료를 둘로 나누어 해당 데이터가 있을만한 곳을 탐색하는 방법
- 데이터가 정렬된 상태이어야함

# 2. 분할 정복 알고리즘과 이진 탐색

- 분할 정복 알고리즘
    - Divide : 문제를 하나 또는 둘 이상으로 나눈다.
    - Conquer : 나눠진 문제가 충북히 작고, 해결이 가능하다면 해결하고, 그렇지 않다면 다시 나눈다
- 이진 탐색
    - Divede : 리스트를 두개의 서브 리스트로 나누다.
    - Conquer
    검색할 숫자(search) > 중간값 이면, 뒷 부분의 서브 리스트에서 검색할 숫자를 찾는다.
    검색할 숫자(search) < 중간값 이면, 앞 부분의 서브 리스트에서 검색할 숫자를 찾는다.
    

# 3. 알고리즘 구현

```bash
public class binary_search {
    public static int[] arr = {5, 2, 3, 1, 9, 11, 15, 16, 33, 23};
    public static void main(String[] args){
				// 정렬 필수 
        Arrays.sort(arr);
        System.out.print("a :"+  binarySearch(5, 0, arr.length-1));
    }

    static boolean binarySearch(int key, int low, int high) {

        int mid;

        if(low <= high){
            mid = (low + high ) / 2;
            if (key == arr[mid]){
                return true;
            }else if (key > arr[mid]){
                return binarySearch(key, mid+1, high);
            }else{
                return  binarySearch(key, low, mid-1);
            }
        }

        return false;
    }
}
```

# 4. 알고리즘 분석

- n개의 리스트를 매번 2로 나누어 1이 될때까지 비교연산을 k회 진행
- n = 2ᴷ = log₂N = log₂2ᴷ
- log₂N k
- 빅오 표기법으로는 k+1이 결국 최종 시간 복잡도임( 1이 되었을 때도, 비교연산을 한번 수행)
    - 결국 O(log₂N+1)이고, 상수는 삭제 되므로, O(logN)