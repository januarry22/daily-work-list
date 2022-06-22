# 삽입 정렬 (Selection Sort)

# 1. 삽입 정렬 (Insertion sort) 란?

- 삽입 정렬은 두 번째 인덱스부터 시작
- 해당 인덱스(key값) 앞에 있는 데이터(B)부터 비교해서 key 값이 더 작으면, B값을 뒤 인덱스로 복사
- 이를 key 값이 더 큰 데이터를 만날때까지 반복, 그리고 큰 데이터를 만난 위치 바로 뒤에 key 값을 이동

# 2. 삽입 정렬 실행 과정

**1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다. (첫 번째 타겟은 두 번째 원소부터 시작한다.)**

**2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환한다.**

**3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.**

![https://blog.kakaocdn.net/dn/rgSWN/btqJSccHxFF/BSSgTzuxatQ4DioqEqGAgK/img.gif](https://blog.kakaocdn.net/dn/rgSWN/btqJSccHxFF/BSSgTzuxatQ4DioqEqGAgK/img.gif)

# 3. Java 코드 구현

```bash
public class insertion_sort {
    public static void main(String[] args){
        int[] insertion = {3, 5, 10, 1, 8, 7, 2, 4};

        /*
         * 두번째 원소부터 비교 시작
         */
        for(int i = 1; i<insertion.length-1;i++){
            /*
             * 비교 대상 원소
             */
            for(int j = i+1 ; j > 0; j--) {
                if(insertion[j] < insertion [j - 1]) {
                     swap(insertion, j, j - 1);
                }else{
                    break;
                }
            }
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
- 최악의 경우 n(n-1)/2
- 완전 정렬이 되어 있는 상태라면 최선은 O(n)

**[장점]**

1. 추가적인 메모리 소비가 작다.

2. 거의 정렬 된 경우 매우 효율적이다. 즉, 최선의 경우 O(N)의 시간복잡도를 갖는다.

3. 안장정렬이 가능하다.

**[단점]**

1. 역순에 가까울 수록 매우 비효율적이다. 즉, 최악의 경우 O(N2)의 시간 복잡도를 갖는다.

2. 데이터의 상태에 따라서 성능 편차가 매우 크다.