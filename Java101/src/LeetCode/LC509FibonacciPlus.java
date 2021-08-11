package LeetCode;

public class LC509FibonacciPlus {
    public static int fib(int n){
        int a = 0;
        int b = 1;
        if ( n == 0)
            return 0;
        if (n==1)
            return 1;
        for(int i = 0; i < n;i ++){
            int c = a;
            a = b;
            b = c + b;
        }
        return a;
    }
    public static void main(String[] args){
        System.out.println(fib(Integer.valueOf(args[0])));
    }
}
