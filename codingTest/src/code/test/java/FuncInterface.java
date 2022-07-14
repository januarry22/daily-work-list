package code.test.java;

/*
 *  java - 람다식 함수형 인터페이스
 * */

import java.util.Objects;

public class FuncInterface {


    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);

    }

    @FunctionalInterface
    public interface Function<Integer, String> {
        String apply(int t);
    }

    class FuncTest{
        private int fcNum;
        private String fcName;

        public FuncTest(int fcNum, String fcName){
            this.fcNum = fcNum;
            this.fcName = fcName;
        }
    }

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "This is Supplier<T>";
        System.out.println(supplier.get());


        Consumer<String> consumer = (str) ->  System.out.println(str);
        consumer.accept("This is Consumer<T>");
        
    }



}
