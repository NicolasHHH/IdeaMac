package INF4112021;

public class Union_find {
    private int[] link;
    private int[] rank;

    Union_find(int n){
        if( n<0 ) throw new IllegalArgumentException();
        this.link = new int[n];
        for( int i = 0; i<n;i++){
            this.link[i] = i; // { 1, 2, 3, 4, ... }
        }
        this.rank = new int[n];
    }

    // trouver le representant
    int find(int i){
        if ( i<0 || i>=this.link.length){
            throw new ArrayIndexOutOfBoundsException(i);
        }
        int p = this.link[i];  // { ... , ai-1, ai, ai+1, ... }
        if (p == i) return i;

        int r = this.find(p);
        this.link[i] = r;
        return r;
    }
    // la prochaine fois on appelle find(p), on trouvra r associé directement

    void union(int i, int j){
        int ri = this.find(i);
        int rj = this.find(j);
        if (ri == rj) return ;// i et j partage le même représ donc sont dans la même classe
        if ( this.rank[ri] < this.rank[rj] ){
            this.link[ri] = rj;
        }
        else {
            this.link[rj] = ri;
            if (this.rank[ri] == this.rank[rj]) {
                this.rank[ri]++;
            }
        }
    }
    void afficher(){
        System.out.println( );
        System.out.print( "rank : " );
        for (int i = 0;i < this.rank.length ; i++){
            System.out.print( rank[i]+" " );
        }
        System.out.println( );
        System.out.print( "link : " );
        for (int i = 0;i < this.link.length ; i++){
            System.out.print( link[i]+" " );
        }
        System.out.println( );
    }
    public static void main(String[] args){
        Union_find uf = new Union_find(18);
        uf.afficher();
        uf.union(1,13);
        uf.union(2,11);
        uf.union(11,1);
        uf.union(6,2);

        uf.afficher();
        System.out.println( uf.find(6));
        uf.afficher();

        uf.union(7,10);
        uf.union(12,10);
        uf.union(12,14);
        uf.union(16,10);

        uf.afficher();
        System.out.println( uf.find(14));
        uf.afficher();

        System.out.println( uf.find(9));
        uf.afficher();


    }



}
