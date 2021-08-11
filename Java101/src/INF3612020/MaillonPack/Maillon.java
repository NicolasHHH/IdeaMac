package INF3612020.MaillonPack;

public class Maillon {
    public int contenu;
    public Maillon suivant;
    public Maillon(int c, Maillon m){
        this.contenu = c;
        this.suivant = m;
    }
    public String toString(){
        return " "+this.contenu+" -> ";
    }
    public boolean contient_obj(int x){
        if(this.contenu == x)
            return true;
        else{
            if(this.suivant == null)
                return false;
            else
                return this.suivant.contient_obj(x);
        }
    }
    public static boolean contient(Maillon m, int x){
        if(m == null)
            return false;
        else{
            if(m.contenu == x)
                return true;
            else
                return contient(m.suivant, x);
        }
    }
    public static Maillon copier(Maillon m){
        if(m == null)
            return null;
        else
            return new Maillon(m.contenu, copier(m.suivant));
    }
    public static Maillon enlever(Maillon m, int x){
        if(m == null)
            return null;
        else{
            if(m.contenu == x)
                return copier(m.suivant);
            else
                return new Maillon(m.contenu, enlever(m.suivant,x));
        }
    }
    public static Maillon supprimerSansCopie(Maillon m, int x) {
        if (m == null)
            return null;
        else {
            if (m.contenu == x)
                return m.suivant;
            else {
                m.suivant = supprimerSansCopie(m.suivant, x);
                return m;
            }
        }
    }
    public static int longueur(Maillon m){
        int lg = 0;
        while( m != null){
            lg++;
            m = m.suivant;
        }
        return lg;
    }
    public static int longueurRec(Maillon m){
            if(m == null) return 0;
            else return 1 + longueurRec(m.suivant);
    }
    public static Maillon ajouterEnQueue(Maillon m, int x){
        if(m == null)
            return new Maillon(x, null);
        else{
            m.suivant = ajouterEnQueue(m.suivant, x);
            return m;
        }
    }
}
