# 선택 정렬 (Selection Sort)

# 1. 선택정렬 (Selection Sort) 란?

- 다음과 같은 순서를 반복하여 정렬하는 알고리즘
    1. 주어진 데이터 중 최소값을 찾음
    2. 해당 최소값을 데이터 맨 앞에 위치한 값과 교체
    3. 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복

![https://blog.kakaocdn.net/dn/ciIAf3/btqJU4kKjyp/jUrWdJgg9oXn3oUrjck7TK/img.gif](https://blog.kakaocdn.net/dn/ciIAf3/btqJU4kKjyp/jUrWdJgg9oXn3oUrjck7TK/img.gif)

# 2. 선택정렬 실행 과정

**1. 주어진 리스트에서 최솟값을 찾는다.**

**2. 최솟값을 맨 앞 자리의 값과 교환한다.**

**3. 맨 앞 자리를 제외한 나머지 값들 중 최솟값을 찾아 위와 같은 방법으로 반복한다.**

# 3. Java 코드

```bash

/*
* JAVA 선택 정렬 selection sort
* */

public class selection_sort {
    public static void main(String[] args){
        int[] selection = {3, 5, 10, 1, 8, 7, 2, 4};

        for(int i = 0; i<selection.length-1;i++){
            int lowest = i;
            for(int j = i+1 ; j < selection.length; j++) {
                /*
                 * 최소값 찾을 때 까지 루프
                 */
                if(selection[lowest] > selection [j]) {
                     lowest = j;
                }
            }
            swap(selection, lowest, i);
        }
    }

    public static void swap(int[] nonebubble, int prev, int next){

        int temp = nonebubble[prev];
        nonebubble[prev] = nonebubble[next];
        nonebubble[next] = temp;

    }
}
```

# 4. 알고리즘 분석

- 반복문이 두개 O(n²)
- 실제로 상세하게 계산하면, n(n-1)/2

**[장점]**

1. 추가적인 메모리 소비가 작다.

**[단점]**

1. 시간복잡도가 **O(N2)** 이다.

2. 안정 정렬이 아니다.