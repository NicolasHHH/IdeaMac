package StackTest;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Zhan {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String item = "Hello string Hello";
        stack.push(item);
        stack.push(item);
        stack.push(item);
        StdOut.println("(" + stack.size() + " left on stack)");
        StdOut.println(stack.toString());
        System.out.println(888);
    }
}
