package INF3612020.MaillonPack;

public class ListeChainee {
    private Maillon tete;
    public ListeChainee(){
        this.tete = null;
    }
    public boolean estVide(){
        return this.tete == null;
    }
    public void ajouterEnTete(int x){
        this.tete = new Maillon(x,this.tete);
    }
    public String toString(){
        String str = "";
        Maillon m = this.tete;
        while(m != null){
            str += m.toString();
            m = m.suivant;
        }
        return str + "null";
    }
    public boolean contient_obj(int x){
        if(this.tete == null)
            return false;
        else
            return this.tete.contient_obj(x);
    }
    public boolean contient(int x){
        return Maillon.contient(this.tete, x);
    }
    public ListeChainee copier(){
        ListeChainee nouveau = new ListeChainee();
        nouveau.tete = Maillon.copier(this.tete);
        return nouveau;
    }
    public void ajouterEnQueue(int x){
        this.tete = Maillon.ajouterEnQueue(this.tete, x);
    }
    public int enleverEnTete(){
        int c = this.tete.contenu;
        this.tete = this.tete.suivant;
        return c;
    }
    public int enleverEnQueue(){
        Maillon m = this.tete, avantdernier = null;
        while(m.suivant != null){
            avantdernier = m; // localisation
            m = m.suivant;
        }
        int c = m.contenu;
        if(m == this.tete) // cas [tete = m] -> null
            this.tete = null;
        else // avantdernier -> m -> null
            avantdernier.suivant = null;
        return c;
    }
}
