package code.test.algorithm;

/*
* JAVA 재귀 함수
* */
public class recursive {
    public static void main(String[] args){

        for (int i=0; i<10; i++){
            System.out.print(factorial1(i)+"\n");
        }


        for (int i=0; i<10; i++){
            System.out.print(factorial2(i)+"\n");
        }
    }

    public static int factorial1(int num){
        if (num > 1)
            return  num * factorial1(num-1);
        else
            return num;
    }


    public static int factorial2(int num){
        if (num <= 1)
            return  num;
        int result_value = num * factorial2(num-1);
            return result_value;
    }

}
