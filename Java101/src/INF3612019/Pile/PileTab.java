package INF3612019.Pile;

import static INF3612019.Pile.TestPile.TesterPile;

public class PileTab implements Pile{
    private int taille,hauteur;
    private int[] t;
    public PileTab(){
        this.taille = 16;
        this.t = new int[this.taille];
        this.hauteur -= 1;
    }
    public boolean estVide(){
        return this.hauteur == -1;
    }
    public void empiler( int x){
        this.hauteur += 1;
        if (this.hauteur > this.taille){
            int[] tmp = new int[2*this.taille];
            for (int i = 0; i<this.taille; i++){
                tmp[i] = this.t[i];
            }
            this.taille = 2*this.taille;
            this.t = tmp;
        }
        this.t[this.hauteur] = x;
    }
    public int depiler(){
        return this.t[this.hauteur--];
    }

    public static void main(String[] args){
        TesterPile(new PileTab());
    }
}
