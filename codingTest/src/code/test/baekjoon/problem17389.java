package code.test.baekjoon;

/*
 * 백준 - 보너스 점
 * */
public class problem17389 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] wait = new int[N];
//        for(int i = 0; i < N; i++) {
//            wait[i] = sc.nextInt();
//        }
        int N = 8;
        String str = "XOOOXOOX";


        int sum=0;
        int bonus =0;
        int result = 0;
        int score = 0;
        for(int i = 0; i<str.length(); i++){
               if(str.charAt(i)=='O'){
                   score = (i+1)+bonus;
                   bonus++;
               }else{
                   bonus = 0;
                   score = 0;
               }
            sum+=score;
        }

        System.out.println(sum);
    }

}
