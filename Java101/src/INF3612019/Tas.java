package INF3612019;

public class Tas {
    private int[] tas = new int[20];
    private int n;
    public Tas(int tmax){
        this.tas = new int[tmax+1];
        this.n = 0;
    }
    public Tas(int[] a){
        this.tas = new int[a.length+1];
        for(int i = 0; i<a.length;i++)
            this.inserer(a[i]);
    }
    public boolean estVide(){
        return this.n == 0;
    }
    public boolean estTas(){
        for (int i = this.n; i>1 ; i --){
            if (this.tas[i] < this.tas[i/2]){
                return false;
            }
        }
        return true;
    }
    public boolean inserer(int x){
        if (this.n >= this.tas.length)
            return false;
        int[] prolong = new int[this.tas.length+1];
        for(int i = 0; i<this.tas.length;i++)
            prolong[i]=this.tas[i];
        this.tas = prolong;
        this.tas[this.n] = x;
        this.monter(this.n);
        this.n+=1;
        return true;
    }
    public void monter(int k){
        int v = this.tas[k];
        while((k>1) && (this.tas[k/2]>=v)){
            this.tas[k] = this.tas[k/2];
            k/=2;
        }
        this.tas[k] =v;
    }
    public int tacheSuivante(){
        int tache = this.tas[1];
        this.tas[1]= this.tas[this.n];
        this.n -= 1;
        this.descendre(1);
        return tache;
    }
    public void descendre(int k){
        int v = this.tas[k],j;
        while(k<=this.n/2){
            j = 2 *k;
            if (j < this.n && this.tas[j]>this.tas[j+1])
                j++;
            if ( v <= this.tas[j])
                break;
            else{
                this.tas[k] = this.tas[j];
                k = j;
            }
            this.showtas();
        }
        this.tas[k] =v;
        this.showtas();
    }
    public void showtas(){
        for (int i = 1; i<=n; i++){
            System.out.print(this.tas[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] a = new int[]{0,1,2,5,12,11,7,10,14,15,13};
        Tas TT = new Tas(a);
        TT.showtas();
        TT.inserer(4);
        TT.showtas();
    }

}
