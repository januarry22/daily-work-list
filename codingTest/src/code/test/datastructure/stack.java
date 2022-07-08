package code.test.datastructure;

import java.util.Stack;

/*
* JAVA 배열
* */
public class stack {
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();

        stack.push("itme::1");
        stack.push("itme::2");
        stack.push("itme::3");

        System.out.println(stack);

        System.out.println(stack.peek());   // stack 최상단 값 -> item3

        System.out.println(stack.pop());   // stack 최상단 값이 꺼내짐 -> item3

        System.out.println(stack.peek());   // item3이 pop()되었으므로 item2가 peek가 됨.


    }

}
