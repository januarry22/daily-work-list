# 탐욕법 (Greedy)

# 1. 탐욕 알고리즘 (Greedy Algorithm )란 ?

- **매 선택단계에서 현재 당장 최적인 답**
- **현재 선택이 남은 선택에 영향을 끼칠지 고려하지 않음**
- **한 문제를 탐욕적으로 해결하는 방법이 한가지만은 아니기 때문에 정당성을 증명해야함**

# 2. 탐욕 알고리즘 정당성 증명

- **탐욕 선택 속성 (Greedy Choice Property)**
    
    → 이전의 선택이 이후에 영향을 주지 않음
    
    → 답의 모든 부분을 고려하지 않고 탐욕적으로만 선택해도 최적해를 구할 수 있음
    
- **최적 부분 구조 (Optimal Substructure)**
    
    → 부분 문제의 최적결과가 전체에도 그대로 적용 될 수 있어야함
    

# 3. 탐욕 알고리즘의 한계

- 탐욕 알고리즘은 근사치 추정에 활용
- 반드시 최적의 해를 구할 수 있는 것은 아니기 때문
- 최적의 해에 가까운 값을 구하는 방법 중의 하나임

# 4. 예시 문제

### 문제 1 : 동전 문제

- 지불해야 하는 값이 4720원 일 때 1원 50원 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오.
    - 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현

```java
public static void coin(int[] arr, int total) {

        int total_coin_cnt = 0;

        List<Object> result = new ArrayList<>();

        for (int coin : arr) {
            Map<Integer, Integer> combi = new HashMap<>();
						
            int coin_cnt = total / coin;
            total_coin_cnt += coin_cnt;
            total -= coin * coin_cnt;

            combi.put(coin, coin_cnt);
            result.add(combi);
        }

        System.out.println(result.toString());
        System.out.println("동전의 개수 :   "+total_coin_cnt);

    }
```

- total_coin_cnt : 필요한 동전의 개수
- 값이 제일 큰 동전으로 먼저 개수를 구함
- 코인의 개수 * 코인값을 전체 total에서 뺌
- 루프를 실행하며 줄어든 total에서 동전 개수를 구해나감

### 문제2 : 부분 배낭 문제 (Fractional Knapsack Problem)

- 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
    - 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
    - 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음, 그래서 Fractional Knapsack Problem 으로 부름
    - Fractional Knapsack Problem 의 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재함 ( 0/1 Knapsack Problem) 으로 부름