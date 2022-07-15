# 힙 정렬 (Heap Sort)

## 1. 힙 정렬?

- 완전 이진 트리를 기본으로 하는 힙(Heap) 자료구조를 기반으로한 정렬 방식
- 불안정 정렬에 속함

![https://upload.wikimedia.org/wikipedia/commons/1/1b/Sorting_heapsort_anim.gif](https://upload.wikimedia.org/wikipedia/commons/1/1b/Sorting_heapsort_anim.gif)

## 2. 수행 과정

1. 최대 힙(Max Heap)을 만족하도록 재구성(**heapify)**
   - 힙은 형제노드 사이의 우선순위는 고려되지 않음. (완전정렬 상태가 아님)
2. 현재 힙 루트는 가장 큰 값이 존재함. 루트의 값을 마지막 요소와 바꾼 후, 힙의 사이즈 하나 줄임
3. 힙의 사이즈가 1보다 크면 위 과정 반복

## 3. 구현

```java
import java.util.Arrays;

/*
* JAVA 힙 정렬
*
* */
public class heapSort {
    public static int[] arr = {5, 2, 3, 1, 9, 11, 15, 16, 33, 23};
    public static void main(String[] args){

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

		/* maxheap 초기화 하면서 값 정렬 */
    static void heapSort(int[] arr) {
        int len = arr.length;

        for(int i =(len/2)-1; i>=0; i--){
            heapify(arr, len, i);
        }

        for(int i = len-1; i>0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

		/* heapify 과정으로 최대힙 다시 구성 */
    public static void heapify(int[] arr, int len, int n){

        int parent=n;
        int left = n*2 +1;
        int right = n*2 +2;
				// 왼쪽 자식 노드
        if(left < len && arr[parent] < arr[left]){
            parent = left;
        }
				// 오른쪽 자식 노드
        if(right < len && arr[parent] < arr[right]){
            parent = right;
        }
				// 부모노드 < 자식 노드
        if(n != parent){
            swap(arr, parent, n);
            heapify(arr, len, parent);
        }

    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
```

## 4. 특징

- 최대 k 만큼 떨어진 요소들을 정렬 하거나
- 최대값 혹은 최소값을 구할때 유용
- 시간복잡도
  - 단일 수행에서 최악의 경우 트리의 높이만큼 비용 발생 **(log₂N)**
  - N개의 원소 만큼 반복하기 때문에 최종적으로 **O(NlogN)**
