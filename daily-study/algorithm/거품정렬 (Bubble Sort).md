# 거품정렬 (Bubble Sort)

# 1. 버블 정렬 (bubble sort )란?

- 두 인접한 데이터를 비교해서, 앞에 있는 데이터가 뒤에 있는 데이터보다 크면, 자리를 바꾸는 정렬 알고리즘

## 버블 정렬 실행 과정

**1. 앞에서부터 현재 원소와 바로 다음의 원소를 비교한다.**

**2. 현재 원소가 다음 원소보다 크면 원소를 교환한다.**

**3. 다음 원소로 이동하여 해당 원소와 그 다음원소를 비교한다.**

![https://blog.kakaocdn.net/dn/KGGTn/btqJRlt96E9/TqlLV0bIIaHaOzi3ubuWYk/img.gif](https://blog.kakaocdn.net/dn/KGGTn/btqJRlt96E9/TqlLV0bIIaHaOzi3ubuWYk/img.gif)

# 3. Java 코드로 구현

```bash

/*
* JAVA 버블 정렬 bubble sort
* */
public class bubblesort {
    public static void main(String[] args){
        int[] nonebubble = {5, 2, 3, 1};
        boolean swaps = false;

        for(int i = 0; i<nonebubble.length-1;i++){
            for(int j = 0; j<nonebubble.length-i -1; j++) {
                if(nonebubble[j] > nonebubble [j + 1]) {
                    swaps = swap(nonebubble, j, j + 1);
                }

								/*
								* 교환할 데이터가 없을 경우 반복문 정지
								* */
                if (!swaps){
                    break;
                }
            }
        }

    }

    public static boolean swap(int[] nonebubble, int prev, int next){
        boolean swaps = true;
        int temp = nonebubble[prev];
        nonebubble[prev] = nonebubble[next];
        nonebubble[next] = temp;

        return swaps;
    }
}
```

# 4. 알고리즘 분석

- 반복문이 두개 O(n²)
- 최악의 경우 n(n-1)/2
- 완전 정렬이 되어 있는 상태라면 최선은 O(n)

**[장점]**

1. 추가적인 메모리 소비가 작다.

2. 구현이 매우 쉽다.

3. 안정정렬이 가능하다.

**[단점]**

1. 다른 정렬 알고리즘에 비해 교환 과정이 많아 많은 시간을 소비한다.