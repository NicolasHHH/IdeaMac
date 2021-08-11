package INF3612019.RechercheExh;

public class CodeGray {
    public static void Gray(int n){
        int gi = 0;
        affichergi(0,n);
        for (int i = 1; i <(1<<n);i++){
            int k = i, j;
            for (j = 0;j<n;j++){
                if((k%2)==1)
                    break;
                k/=2;
            }
            gi ^= (1<<j);
            affichergi(gi,n);
        }
    }
    public static void afficherAux(int gi,int j, int n){
        if(j>=0){
            afficherAux(gi>>1,j-1,n);
            System.out.print((gi&1));
        }
    }
    public static void affichergi(int gi, int n){
        afficherAux(gi,n-1,n);
        System.out.println("="+gi);
    }
}
