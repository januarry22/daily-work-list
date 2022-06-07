package code.test.programmers;

import java.util.Arrays;

/*
* [프로그래머스] - 로또의 최고 순위와 최저 순위
 * */
public class lessons77484 {
    public static int[] lottos = {44, 1, 0, 0, 31, 25};
    public static int[] win_nums = {31, 10, 45, 1, 6, 19};

    public static void main(String[] args){
        int[] answer = solution(lottos, win_nums);
        System.out.print(answer);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        // 값 순서 대로 정렬
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int sumSet = 0;
        int unknownSet = 0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                unknownSet ++;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i]==win_nums[j]){
                    sumSet ++;
                }
            }
        }

        System.out.print("최소로 나올수 있는 맞힌 수"+sumSet+"\n");
        System.out.print("최대로 나올수 있는 맞힌 수"+(sumSet+unknownSet)+"\n");

        answer[0] = returnValue(sumSet);
        answer[1] = returnValue(sumSet+unknownSet);

        return answer;
    }

    public static int returnValue(int setvalue){

        switch (setvalue){
            case 6:
                setvalue = 1;
            case 5:
                setvalue = 2;
            case 4:
                setvalue = 3;
            case 3:
                setvalue = 4;
            case 2:
                setvalue = 5;
            default:
                setvalue =6;
            break;
        }

        return setvalue;
    }

}
