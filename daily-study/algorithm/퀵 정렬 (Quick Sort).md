# 퀵 정렬 (Quick Sort)

## 1. 퀵 정렬이란?

- Quick Sort은 **분할 정복(divide and conquer) 방법** 을 통해 주어진 배열을 정렬
- **불안정 정렬**이며, 다른 원소와 비교만으로 정렬 할 수 있는 **비교정렬**
- 

## 2. 퀵 정렬 수행 과정

- 주어진 배열 가운데원소를 기준점(**pivot** 이라고 부름)으로 정해서,
- 기준점보다 작은 데이터는 왼쪽(left), 큰 데이터는 오른쪽(right)으로 모으는 함수를 작성함
    - **분할(Divide)** 과정으로 분할을 마친뒤 피벗은 움직이지 않음.
- 각 왼쪽(left), 오른쪽(right)은 재귀용법을 사용해서 다시 동일 함수를 호출하여 위 작업을 반복함
- 함수는 왼쪽(left) + 기준점(pivot) + 오른쪽(right)을 리턴함

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbwegCi%2FbtqJVPAO8oc%2FUxwsfDMoZ8VpkoWTmx2eNK%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbwegCi%2FbtqJVPAO8oc%2FUxwsfDMoZ8VpkoWTmx2eNK%2Fimg.png)

## 3. 구현

- 정복 (Conquer)
    - 부분 배열을 정렬. 부분 배열의 크기가 충분하지 않으면 다시 재귀를 통해 분할 정복 실행

```java
public static void sort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
}
```

- 분할 (Divide)
    - 입력 배열을 피벗 기준으로 비균등하게 2개의 부분 배열로 분할 (왼쪽 < 피벗, 피벗 < 오른쪽)

```java
public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;

        while (i < j) {
            while (pivot < arr[j]) {
                j--;
            }
            while (i < j && pivot >= arr[i]) {
                i++;
            }
            swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
```

## 4. 알고리즘 분석

- 병합정렬과 유사, 시간복잡도는 **O(nlog n)**
    - 단, 최악의 경우 **O(n²)**
        - 맨 처음 Pivot이 가장 크거나, 가장 작으면모든 데이터를 비교하는 상황이 나음

[장점]

- 불필요한 데이터의 이동을 줄이고 먼 거리의 데이터를 교환할 뿐아니라, 한 번 결정된 피벗들이 추후 연산에서 제외되는 특성 때문에 같은 시간복잡도 O(nlog₂n)을 가지는 정렬 알고리즘과 비교했을때도 가장 빠름
- 배열안에서 교환 되기 때문에 별도의 메모리 공간이 필요하지 않음

[단점]

- 불안정 정렬
- 정렬된 배열 (오름차순, 내림차순 등) 에 대해서는 수행시간이 오히려 더많이 소요