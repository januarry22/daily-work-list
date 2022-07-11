# 병합 정렬 (Merge Sort)

# 1. 병합정렬 (Merge Sort)?

- 재귀용법을 활용한 정렬 알고리즘
    
    
    ![https://blog.kakaocdn.net/dn/GD4LL/btqJWSDyKHS/2RNiqbImdYuC5QEUzDT0zk/img.gif](https://blog.kakaocdn.net/dn/GD4LL/btqJWSDyKHS/2RNiqbImdYuC5QEUzDT0zk/img.gif)
    
    # 2. 병합 정렬 실행과정
    
    [https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F07jQt%2Fbtq1lao22zT%2FKkr0QfF1VGxi3bfGYp2r61%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F07jQt%2Fbtq1lao22zT%2FKkr0QfF1VGxi3bfGYp2r61%2Fimg.png)
    
    1. **리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.**
    2. **부분 리스트의 길이가 1이 아니라면 1번 과정을 반복한다.**
    3. **인접한 두 부분 리스트를 다시 하나의정렬된 리스트로 합병한다.**
    
    # 3. 구현
    
    ```java
    
    public static void main(String[] args) {
    
            int[] arr = {5, 2, 3, 1, 7, 4, 6, 9};
    
            System.out.println(Arrays.toString(arr));
    				// [5, 2, 3, 1, 7, 4, 6, 9]
            System.out.println(Arrays.toString(merge(arr)));
    				// [1, 2, 3, 4, 5, 6, 7, 9]
    }
    
    public static int[] merge(int arr[]) {
            if (arr.length<2){
                return arr;
            }
            int mid = (arr.length) / 2;
    
            int[] left_arr = merge(Arrays.copyOfRange(arr, 0, mid));
            int[] right_arr = merge(Arrays.copyOfRange(arr, mid, arr.length));
    
            int[] SORTED = new int[arr.length];
            int left_p=0, right_p=0, idx=0;
    
            while(left_p < left_arr.length && right_p <right_arr.length){
                if(left_arr[left_p] < right_arr[right_p]){
                    SORTED[idx++] = left_arr[left_p++];
                }else{
                    SORTED[idx++] = right_arr[right_p++];
                }
            }
    
            while(left_p < left_arr.length){
                SORTED[idx++] = left_arr[left_p++];
            }
    
            while (right_p < right_arr.length){
                SORTED[idx++] = right_arr[right_p++];
            }
    
            return SORTED;
        }
    ```
    
    # 4. 알고리즘 분석
    
    - 시간 복잡도 : **O(nlogN)**
    - O(n) * O(log n)
    
    ![https://www.fun-coding.org/00_Images/mergesortcomplexity.png](https://www.fun-coding.org/00_Images/mergesortcomplexity.png)
    
    **[장점]**
    
    1. 항상 두 부분리스트로 쪼개어 들어가기 때문에 최악의 경우에도 **O(NlogN)** 으로 유지가 된다.
    
    2. 안정정렬 
    
    **[단점]**
    
    1. 정렬과정에서 추가적인 보조 배열 공간을 사용하기 때문에 메모리 사용량이 많다.
    
    2. 보조 배열에서 원본배열로 복사하는 과정은 매우 많은 시간을 소비하기 때문에 데이터가 많을경우 상대적으로 시간이 많이 소요된다.