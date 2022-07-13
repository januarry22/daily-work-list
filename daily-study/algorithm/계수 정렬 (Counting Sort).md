# 계수 정렬 (Counting Sort)

## 1. 계수 정렬 (Counting Sort) ?

- 정렬 내에서 데이터의 값이 몇 번 나왔는지를 세주는 것

## 2. 정렬 과정

- array 를 한 번 순회하면서 각 값이 나올 때마다 해당 값을 index 로 하는 **새로운 배열(counting)**의 값을 1 증가
- counting 배열의 각 값을 누적합으로 변환
- **counting 배열의 각 값은 (시작점 - 1)**
    - 해당 값에 대응 되는 위치에 배정
- 안정정렬 하기 위해 array 배열의 마지막 부터 순회

## 3. 구현

```java

import java.util.Arrays;

/*
 * JAVA radix sort
 * */
public class countingSort {
    public static void main(String[] args) {
        int[] arr = {11, 5, 35, 39, 21, 49, 12, 38};

        int[] counting = new int[50];    // 배열의 최대값을 배열길이로함
        int[] result = new int[8];

        // 1 : arr 의 value 값을 index 로 하는 counting 배열 값 1 증가
        for(int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        // 2 : counting 배열 누적합
        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 3:  counting 배열의 값을 인덱스로 하여 result에 value 값을 저장
        for(int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        System.out.println(" * 초기 배열 : arr");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println(" * counting 배열 ");
        for(int i = 0; i < counting.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.print("[  "+ i  +" ]\t");
            System.out.print( counting[i] + "\t");
        }
        System.out.println();

        System.out.println();

        System.out.println("* 정렬 후 : result");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

}
```

## 4. 알고리즘 분석

- 시간복잡도 ***𝚶(𝑛) 을 가짐***
    - O(n + k) , 여기서 k는 배열에 포함되어 있는 최대값이지만 상수이므로 고려하지않음
- 배열에 포함된 숫자의 최댓값 만큼의 메모리를 필요로함
    - 최대값 N만큼 counting 배열의 크기가 증가
- 메모리 낭비가 큼
- 정렬하는 숫자가 특정한 범위 내에 있을 때만 사용