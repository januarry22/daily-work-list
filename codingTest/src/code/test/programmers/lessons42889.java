package code.test.programmers;

import java.util.*;

/*
* [프로그래머스] - 실패율
* */
public class lessons42889 {
    public static int N = 5;
    public static int[] stages={2, 1, 2, 6, 2, 4, 3, 3};

    public static void main(String[] args){
        int answer[] = solution(N, stages);

        Arrays.stream(answer).forEach(n -> System.out.println(n));
    }

    public static int[] solution(int N, int[] stages) {
        int answer[] = new int[N+1];
        double doubleArray[] = new double[N+1];
        Map<Integer,Double> resultMap = new HashMap<Integer,Double>();

        Arrays.sort(stages);

        int failMinusCnt =0;
        for(int i=1; i<N+1; i++){
            int failCnt = 0;
            for(int j : stages){
                if(j == i){
                    failCnt++;
                }
            }
            double nextLength = stages.length-failMinusCnt;
          //  doubleArray[i] = failCnt/nextLength;
            double result = failCnt/nextLength;
            failMinusCnt += failCnt;
            resultMap.put(i,result);
        }
        List<Integer> listKeySet = new ArrayList<>(resultMap.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (resultMap.get(value2).compareTo(resultMap.get(value1))));

        answer = listKeySet.stream().mapToInt(i -> i).toArray();

        return answer;
    }

}
