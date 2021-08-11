package INF3612019;

public class Récursivité {
    public static int Factoriel(int n){
        if (n==0) return 1;
        else return  n*Factoriel(n-1);
    }
    public static int NinetyOne(int n){
        System.out.println(n);
        if (n>100) return n-10;
        else return NinetyOne(NinetyOne(n+11));
    }
    public static void binaire(int n){
        if (n>0) {
            binaire(n/2);
            System.out.print(n%2);
        }
    }
    public static void Hanoi(int n, int D, int M, int A){
        if (n>0){
            Hanoi(n-1, D ,A, M);
            System.out.println("bouge"+D+"ver"+A);
            Hanoi(n-1, M, D, A);
        }
    }
    public static void main(String[] args){
        System.out.println(Factoriel(5));
        System.out.println(Factoriel(1));
        System.out.println(Factoriel(0));
        System.out.println();
        System.out.println(NinetyOne(50));
        binaire(26);
        System.out.println();
        binaire(15);
        System.out.println();
        Hanoi(5,1,2,3);
    }
}
