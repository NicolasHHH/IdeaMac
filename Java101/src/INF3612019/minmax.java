package INF3612019;

public class minmax {
    public static int[] comparerDeuxEntiers(int a,int b){
        int[] u = new int[2];
        if (a<b){
            u[0] = a; u[1] = b;
        }
        else{
            u[0] = b; u[1] = a;
        }
        return u;
    }
    public static int[] minMax(int[] t, int g,int d){
        int gd = d-g;
        if (gd ==1){
            int[] u = new int[2];
            u[0] = u[1] = t[g];
            return u;
        }
        else if (gd == 2){
            return comparerDeuxEntiers(t[g],t[g+1]);
        }
        else{
            int m = (g+d)/2;
            int[] tg = minMax(t,g,m);
            int[] td = minMax(t,m,d);
            int[] u = new int[2];
            if (tg[0]<td[0])
                u[0] = tg[0];
            else
                u[0] = td[0];
            if (tg[1]> td[1])
                u[1] = tg[1];
            else
                u[1] = td[1];
            return u;
        }
    }
    public static int[] minMax(int[] t){
        return minMax(t,0, t.length);
    }
    public static void main(String[] args){
        int[] t = new int[]{1,4,6,8,9,2,3,6,0}; // ,6,8,9,2,3,6,0
        System.out.println(minMax(t)[1]);
    }
}
