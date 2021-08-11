package DynamicProgm;

public class FibonacciMemo {
    public static int FiboMemo(int n){
        if (n == 1) return 1;
        else if (n == 2) return 1;
        else {
            int a = 1, b=1;
            for (int i = 3; i<n;i++){
                int c = a;
                a = b;
                b = c+b;
            }
            return a+b;
        }
    }
    public static int FiboRec(int n){
        if (n == 1) return 1;
        else if (n == 2) return 1;
        else {
            return FiboRec(n-1)+FiboRec(n-2);
        }
    }
    public static void main(String[] args){
        int n = 45;
        System.out.println(FiboMemo(n));
        System.out.println(FiboRec(n));
        System.out.println(FiboMemo(n));

    }
}
