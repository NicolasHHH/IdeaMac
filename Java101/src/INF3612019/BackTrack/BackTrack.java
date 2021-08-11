package INF3612019.BackTrack;

public class BackTrack {
    public static int nbrec = 0;
    public static void sacAdosRec(int[] a, int S, int[] x, int Si, int i){
        nbrec++;
        if (Si == S)
            afficherSolution(a,S,x,i);
        else if(i<a.length && Si<S) {
            x[i] = 0;
            sacAdosRec(a, S, x, Si, i + 1);
            x[i] = 1;
            sacAdosRec(a, S, x, Si + a[i], i + 1);
        }
    }
    public static void sacAdos(int[] a,int S){
        int[] x = new int[a.length];
        nbrec = 0;
        System.out.println("\n\nTarget:"+S);
        sacAdosRec(a,S,x,0,0);
        System.out.print("  "+nbrec);
        // System.out.println("//"+(1<<(a.length+1)));
    }
    public static void afficherSolution(int[] a, int S, int[] x, int gi ){
        System.out.println();
        System.out.print(S+" = ");
        for (int i = 0; i<gi;i++){
            if(x[i]==1)
                System.out.print("+"+a[i]);
        }
    }
    public static void main(String[] args){
        int y = 101;
        y >>= 1;
        System.out.println(y);
        y = 110;
        y >>= 2;  // transformer en binaire et supprimer les deux derniers chiffres
        System.out.println(y);


        int[] a = new int[]{1,4,7,12,18,20,30};
        sacAdos(a,11);
        sacAdos(a,12);
        sacAdos(a,55);
        sacAdos(a,14);
    }
}
