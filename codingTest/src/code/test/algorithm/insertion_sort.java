package code.test.algorithm;

/*
* JAVA 삽입 정렬 insertion sort
* */
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

        for (int n : insertion){
            System.out.print(n+"\n");
        }
    }

    public static void swap(int[] nonebubble, int prev, int next){

        int temp = nonebubble[prev];
        nonebubble[prev] = nonebubble[next];
        nonebubble[next] = temp;

    }
}
