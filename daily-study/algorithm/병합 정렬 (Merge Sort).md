# 병합 정렬 (Merge Sort)

# 1. 병합정렬 (Merge Sort)?

- 재귀용법을 활용한 정렬 알고리즘
    1. 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
    2. 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
    3. 두 부분 리스트를 다시 하나의정렬된 리스트로 합병한다.
    
    ![https://blog.kakaocdn.net/dn/GD4LL/btqJWSDyKHS/2RNiqbImdYuC5QEUzDT0zk/img.gif](https://blog.kakaocdn.net/dn/GD4LL/btqJWSDyKHS/2RNiqbImdYuC5QEUzDT0zk/img.gif)
    
    # 2. 병합 정렬 실행과정
    
    [https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F07jQt%2Fbtq1lao22zT%2FKkr0QfF1VGxi3bfGYp2r61%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F07jQt%2Fbtq1lao22zT%2FKkr0QfF1VGxi3bfGYp2r61%2Fimg.png)
    
    **1. 주어진 리스트를 절반으로 분할하여 부분리스트로 나눈다. (Divide : 분할)**
    
    **2. 해당 부분리스트의 길이가 1이 아니라면 1번 과정을 되풀이한다.**
    
    **3. 인접한 부분리스트끼리 정렬하여 합친다. (Conqure : 정복)**
    
    # 3. Java 코드로 구현
    
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