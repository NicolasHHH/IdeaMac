package INF3612019;

public class Noeud {
    private int contenu;
    public Noeud gauche, droit;

    public Noeud(int r, Noeud g , Noeud d){
        this.contenu = r;
        this.gauche = g;
        this.droit = d;
    }
    public Noeud(int r){
        this.contenu = r;
        this.gauche = null;
        this.droit = null;
    }

    public int contenu(){
        return this.contenu;
    }
}

