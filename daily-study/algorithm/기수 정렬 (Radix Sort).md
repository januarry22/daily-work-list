# 기수 정렬 (Radix Sort)

## 1. 기수정렬 ?

- 데이터를 구성하는 기본 요소 (Radix) 를 이용하여 정렬을 진행하는 방식
    - 데이터의 값들이 동일한 길이를 가지는 숫자나 문자열로 구성

## 2. 기수정렬 수행 과정

- 데이터 중 가장 큰 자리수 구함
- 가장 작은 자리수부터 가장 큰 자리수 까지 해당 자리수만 보고 Counting sort (계수 정렬) 진행
- [계수 정렬 (Counting Sort)](https://www.notion.so/Counting-Sort-769dec26a1de4205b8fdfcf6cce1bfa0)

 

## 3. 구현

```java

import java.util.Arrays;
import java.util.Random;

/*
 * JAVA radix sort
 * */
public class radixSort {
    static final int N = 10;
    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // 최대값 구하기
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        countingSort(arr,max);
    }

    public static void countingSort(int[] arr,int max) {
        int[] temp = new int[N];
        int[] counting = new int[max+1];

        for (int i = 0; i < N; i++) {
            counting[arr[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = 0; i < N; i++) {
            int index = arr[i];

            counting[index]--;
            temp[counting[index]] = index;
        }

        // 복사
        for (int i = 0; i < N; i++) {
            arr[i] = temp[i];
        }
    }

}
```

## 4. 알고리즘 분석

- 시간 복잡도 : **O(dn)**
    - d는 데이터의 자릿수

[장점]

- 자리수를 가지는 데이터 (문자열과 정수) 정렬가능
- 안정 정렬

[단점]

- 정렬할 수 있는 레코드 타입 제한 (부동소수점 x)
- 중간 결과를 저장할 bucket이 필요함 (추가적인 메모리 소요)