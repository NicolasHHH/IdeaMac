package INF3612019.Permutation;

public class PermRec2 {
    public static void permRec2(int[] t, int n, boolean[] utilise, int i0) {
        if (i0 > n) {
            afficher(t, n);
        } else {
            for (int v = 1; v <= n; v++) {
                if (!utilise[v]) {
                    utilise[v] = true;
                    t[i0] = v;
                    permRec2(t,n,utilise,i0+1);
                    utilise[v] = false;
                }
            }
        }
    }
    public static void permRec2(int n){
        int[] t =new int[n+1];
        boolean[] utilise = new boolean[n+1];
        permRec2(t,n,utilise,1);
    }

    public static void afficher(int[] t, int n){
        for (int i = 1; i< n+1; i++){
            System.out.print(t[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        permRec2(4);
    }
}

