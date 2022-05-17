package code.test.programmers;

/*
* [프로그래머스] - 키패드 누르기
* */
public class lessons67256 {
    public static int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    public static String hand = "right";

    public static void main(String[] args){
        String answer = solution(numbers, hand);
        System.out.print(answer);
    }

    public static String solution(int[] numbers,String hand) {
        String answer = "";

        if(hand =="right"){
            hand="R";
        }
        if(hand=="left"){
            hand="L";
        }

        for(int numHand : numbers){
            String handLeftorRight= null;
            int leftNum=0;
            int rightNum = 0;
            if(numHand==1 || numHand==4 || numHand==7){
                handLeftorRight = "L";
                leftNum = numHand;
            }
            if(numHand==3 || numHand==6 || numHand==9){
                handLeftorRight = "R";
                rightNum = numHand;
            }
            if(numHand==2 || numHand==5 || numHand==8|| numHand==0){
                int reusltset = leftNum - rightNum;
                if(reusltset==0){
                    handLeftorRight = hand;
                }
                // 왼쪽이 더 가까움
                if(Math.abs(numHand - leftNum) > Math.abs(numHand - rightNum)){
                    handLeftorRight = "L";
                    leftNum = numHand;
                }
                // 오른쪽이 더 가까움
                if( Math.abs(numHand - leftNum) <  Math.abs(numHand - rightNum)){
                    handLeftorRight = "R";
                    rightNum = numHand;
                }
            }
            System.out.print("rightNum"+rightNum+"\n");
            System.out.print("leftNum"+leftNum+"\n");
            answer += handLeftorRight;
        }
        return answer;
    }

}
