package INF3612019.RechercheExh;

public class Parcourta {
    public static void afficher(int i, int[] x){
        System.out.print("i="+i+"=");
        for (int j = 0; j< x.length;j++){
            System.out.print(x[j]);
        }
        System.out.println();
    }
    public static void parcourta(int n){
        int retenue; // 二进制进一
        int[] x = new int[n];
        for (int i = 0;i<(1<<n);i++){
            afficher(i,x);
            retenue = 1;
            for(int j = 0; j<n;j++){
                x[j] += retenue;
                if( x[j] == 2){
                    x[j] = 0;
                    retenue = 1;
                }
                else break; // 进一完毕
            }
        }
    }
    public static void SacADos(int[] a, int target){
        int n = a.length,N;
        int[] x = new int[n];
        for ( int i =0;i<(1<<n);i++){
            N = 0;
            for ( int j = 0; j<n;j++)
                if (x[j] ==1)
                    N += a[j];
            if (N == target) {
                System.out.print("S = "+target+ " = " );
                for (int j = 0;j<n ;j++){
                    if(x[j]==1) System.out.print("+"+a[j]);
                }
                System.out.println();
            }

            for (int j = 0; j<n;j++){
                if (x[j] ==1)
                    x[j]=0;
                else {
                    x[j]=1;
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        parcourta(3);
        int[] a = {1,2,5,8,9,3,7,2,3};
        SacADos(a,10);
    }
}
