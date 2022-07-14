package code.test.java;

/*
 *  java - 람다식
 * */

public class lambda {
    @FunctionalInterface
    public interface lambdaEx {
        void lambdaEx();
    }

    @FunctionalInterface
    public interface lambdaEx2 {
        void lambdaEx2(String str);
    }

    @FunctionalInterface
    public interface lambdaEx3 {
        String lambdaEx3();
    }

    @FunctionalInterface
    public interface lambdaEx4 {
        String lambdaEx4(String str);
    }

    public static void main(String[] args) {
        /* 1. 매개변수가 없고, 리턴값이 없는 람다식 */
        lambdaEx fc = () -> {
            System.out.println("CASE1");
            System.out.println("매개변수 X, 리턴값은 X");
            System.out.println("Hello lambda");
            System.out.println();
        };
        fc.lambdaEx();

        /* 2. 매개변수가 있고 , 리턴값이 없는 람다식 */
        lambdaEx2 fc2 = (str) ->{
            System.out.println("CASE2");
            System.out.println("매개변수 O, 리턴값은 X");
            System.out.println("입력"+str);
            System.out.println();
        };
        fc2.lambdaEx2("Java Programming");


        /* 3. 매개변수가 없고 , 리턴값이 있는 람다식 */
        lambdaEx3 fc3 = () ->{
            System.out.println("CASE3");
            System.out.println("매개변수 X, 리턴값은 O");
            return  "Java Programming";
        };

        System.out.println("출력"+fc3.lambdaEx3());
        System.out.println();

        /* 4. 매개변수가 있고 , 리턴값이 있는 람다식 */
        lambdaEx4 fc4 = (str) ->{
            System.out.println("CASE4");
            System.out.println("매개변수 O, 리턴값은 O");
            System.out.println("입력"+str);
            return  "OUT";
        };

        System.out.println("출력"+fc4.lambdaEx4("IN"));
        System.out.println();

    }



}
