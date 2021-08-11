package INF3612019.Polynome;

public class Polynome {
        private int deg;
        private long[] coef;
        public Polynome(int d){
            this.deg = d;
            this.coef = new long[d+1];
        }
        public int degre(){
            return this.deg;
        }

        public void afficher(){
            for (long i : this.coef){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    public static boolean estNul(Polynome P){
        return P.degre() == -1;
    }
    public static long evaluer(Polynome P,long x){
        long Px,xpi;
        if (estNul(P)) return 0;
        Px = P.coef[0];
        xpi = 1;
        for ( int i = 1; i<=P.deg;i++){
            xpi*=x;
            Px+=P.coef[i]*xpi;
        }
        return Px;
    }
    public static void trouverDegre(Polynome P){
        while(P.deg>=0){
            if(P.coef[P.deg]!=0) break;
            else P.deg-=1;
        }
    }
    public static Polynome plus(Polynome P, Polynome Q){
        int maxdeg = (P.deg>= Q.deg ? P.deg: Q.deg);
        int mindeg = (P.deg<=Q.deg ? P.deg : Q.deg);
        Polynome S = new Polynome(maxdeg);

        for ( int i = 0; i <= mindeg; i ++){
            S.coef[i] = P.coef[i] + Q.coef[i];
        }
        for ( int i = mindeg+1; i <= P.deg; i ++){
            S.coef[i] = P.coef[i];
        }
        for ( int i = mindeg+1; i <= Q.deg; i ++){
            S.coef[i] = Q.coef[i];
        }
        trouverDegre(S);
        return S;
    }
    public static Polynome KaraPlus(Polynome P, Polynome Q, int d){
        int mindeg = (P.deg<=Q.deg ? P.deg : Q.deg);
        Polynome S = new Polynome(d);

        for ( int i = 0; i <= mindeg; i ++){
            S.coef[i] = P.coef[i] + Q.coef[i];
        }
        for ( int i = mindeg+1; i <= P.deg; i ++){
            S.coef[i] = P.coef[i];
        }
        for ( int i = mindeg+1; i <= Q.deg; i ++){
            S.coef[i] = Q.coef[i];
        }
        trouverDegre(S);
        return S;
    }
    public static Polynome sous(Polynome P, Polynome Q){
        int maxdeg = (P.deg>= Q.deg ? P.deg: Q.deg);
        int mindeg = (P.deg<=Q.deg ? P.deg : Q.deg);
        Polynome S = new Polynome(maxdeg);

        for ( int i = 0; i <= mindeg; i ++){
            S.coef[i] = P.coef[i] - Q.coef[i];
        }
        for ( int i = mindeg+1; i <= P.deg; i ++){
            S.coef[i] = P.coef[i];
        }
        for ( int i = mindeg+1; i <= Q.deg; i ++){
            S.coef[i] = -Q.coef[i];
        }
        trouverDegre(S);
        return S;
    }
    public static Polynome deChaine(long[] l){
            Polynome P = new Polynome(l.length-1);
            P.coef = l;
            trouverDegre(P);
            return P;
    }
    public static Polynome extraire(Polynome P, int debut, int fin){
            Polynome E = new Polynome(fin - debut);
            for ( int i = debut; i <= fin; i ++){
                E.coef[i-debut] = P.coef[i];
            }
            trouverDegre(E);
            return E;
    }
    public static Polynome mult(Polynome P,Polynome Q ) {
        Polynome R;
        if ( estNul(P) || estNul(Q)) return new Polynome(0);
        R = new Polynome(P.deg+Q.deg);
        for (int i = 0;i<=P.deg;i++)
            for (int j=0;j<=Q.deg;j++){
                R.coef[i+j] += P.coef[i] * Q.coef[j];
        }
        return R;
    }
    // 低次情况 <= 16  转普通mult
    public static Polynome Karatsuba(Polynome P,Polynome Q, int n ) {
            Polynome P0,Q0,P1,Q1,SP,SQ,R0,R1,R2,R;
            int m;
            if ( n <= 1) return mult(P,Q);
            m = n/2;
            if ((n%2)==1) m++;
            P0 = extraire(P, 0,m-1);
            Q0 = extraire(Q, 0,m-1);
            P1 = extraire(P, m,n-1);
            Q1 = extraire(Q, m,n-1);

            R0 = Karatsuba(P0,Q0,m);
            R2 = Karatsuba(P1,Q1,n-m);

            SP = KaraPlus(P0,P1,m-1);
            SQ = KaraPlus(Q0,Q1,m-1);
            R1 = Karatsuba(SP,SQ,m);
            R1 = sous(R1,R0);
            R1 = sous(R1,R2);

            R = new Polynome(2*(n-1));
            for( int i =0; i<=R0.deg;i++)
                R.coef[i] = R0.coef[i];
            for( int i =0; i<=R2.deg;i++)
                R.coef[i+2*m] = R2.coef[i];
            for( int i =0; i<=R1.deg;i++)
                R.coef[i+m] = R1.coef[i];
            trouverDegre(R);

            return R;
    }
    public static void main(String[] args){
            Polynome P,Q,S;
            long[] lp = {3,4};
            P = deChaine(lp);
            long[] lq = {2,1};
            Q = deChaine(lq);
            S = sous(P,Q);
            S.afficher();
            S = Karatsuba(P,Q,2);
            S.afficher();
            S = mult(P,Q);
            S.afficher();
    }
}
