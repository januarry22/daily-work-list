    package code.test.baekjoon;

    import java.io.IOException;
    import java.util.*;

    /*
     * 백준 - 스택 수열
     *
     * */
    public class problem1874 {

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int N =  sc.nextInt();

            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack();
            int start = 1;


            List<String> result = new ArrayList<>();

            for(int i = 0; i<N; i++) {
                int data = sc.nextInt();
                while (start<=data){
                    stack.push(start);
                    start++;
                    result.add("+");
                  //  System.out.println("+");
                }
                if(stack.peek() == data){
                    stack.pop();
                    result.add("-");
                    //System.out.println("-");
                }else{
                    result.add("NO");
                }
            }

            for(String a : result){
                System.out.println(a);
            }

        }

    }
