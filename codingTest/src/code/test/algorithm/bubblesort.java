package code.test.algorithm;

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
                if (!swaps){
                    break;
                }
            }
        }

        for (int n : nonebubble){
            System.out.print(n+"\n");
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
