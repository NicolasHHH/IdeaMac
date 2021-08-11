package INF3612019;

public class Recurrence_Mutuelle {
    public static String DevelopperSin(int n ){
        if (n==0) return "0";
        else if (n==1) return "S";
        else{
            String g = "S*(" + DevelopperCos(n-1) + ")";
            return g+" + C*("+DevelopperSin(n-1)+")";
        }
    }
    public static String DevelopperCos(int n ){
        if (n==0) return "0";
        else if (n==1) return "C";
        else{
            String g = "C*(" + DevelopperSin(n-1) + ")";
            return g+" - S*("+DevelopperCos(n-1)+")";
        }
    }

    public static int f(int z){
        if (z<=0) return 0;
        else return f(z-1)* f(z-3);
    }
    public static int g(int w){
        if (w==0) return 1;
        else{
            if ( (w%2)==1 ) return g(w/2);
            else return g(w/3);
        }
    }
    public static int h(int a){
        if (a<=0) return 1;
        else {
            if (h(a/2)==1) return 2;
            else return 3;
        }
    }
    public static void main(String[] args){
        System.out.println(DevelopperSin(1));
        System.out.println(DevelopperSin(2));
        System.out.println(DevelopperSin(3));
        for (int i = -1; i<30; i++){
            System.out.print(f(i));
        }
        for (int i = -1; i<30; i++){
            System.out.print(g(i));
        }
        for (int i = -1; i<30; i++){
            System.out.print(h(i));
        }
    }

}
