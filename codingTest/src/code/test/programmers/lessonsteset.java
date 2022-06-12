package code.test.programmers;

/*
* [프로그래머스] - 체육복
* */
public class lessonsteset {
    public static int[] p={2,5,3,1, 4};

    public static void main(String[] args){
        int[] answer = solution(p);
        for(int i : answer){

            System.out.print(i);
        }
    }

    public static int[] solution(int[] p) {
        int[] answer = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            int changeCnt = 0;
            for (int j =1; j < p.length - i ; j++) {
                if (p[i] > p[j]) {
                    System.out.print("i"+p[i]+"\n");
                    System.out.print("j"+p[j]+"\n");
                    swap(p, i, j);
                    changeCnt++;
                }
            }
            answer[i] = changeCnt;
            if(changeCnt == 0) break;
        }
        return answer;
    }
    public static void swap(int a[], int i, int j ){
            int temp = a[i];
            a[i]= a[j];
            a[j] = temp;
    }

}
