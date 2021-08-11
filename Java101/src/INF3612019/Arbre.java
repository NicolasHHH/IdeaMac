package INF3612019;

public class Arbre {
    private Noeud racine;
    public Arbre(){
        this.racine = null;
    }
    public Arbre(int c){
        this.racine = new Noeud(c);
    }
    public Arbre(int c, Arbre g, Arbre d){
        this.racine =  new Noeud(c, g.racine,d.racine);
    }
    public Noeud Racine(){
        return this.racine;
    }
    public boolean estVide(){
        return this.racine == null;
    }
    public static void afficherPrefixe(Noeud a){
        if (a != null){
            System.out.print(a.contenu());
            afficherPrefixe(a.gauche);
            afficherPrefixe(a.droit);
        }
    }
    public static void afficherPostfixe(Noeud b){
        if (b != null){
            afficherPostfixe(b.gauche);
            afficherPostfixe(b.droit);
            System.out.print(b.contenu());
        }
    }
    public static void afficherInfixe(Noeud c){
        if (c != null){
            afficherInfixe(c.gauche);
            System.out.print(c.contenu());
            afficherInfixe(c.droit);
        }
    }
    public void afficherInfixe(){ afficherInfixe(this.racine); }
    public void afficherPrefixe(){
        afficherPrefixe(this.racine);
    }
    public void afficherPostfixe(){
        afficherPostfixe(this.racine);
    }

    public static Noeud inserer(Noeud a, int x){
        if ( a == null)
            return new Noeud(x,null,null);
        else if (a.contenu()>=x){
            a.gauche = inserer(a.gauche,x);
            return a;
        }
        else
            a.droit = inserer(a.droit,x);
        return a;

    }
    public void inserer(int x){
        this.racine = inserer(this.racine,x);
    }

    public Noeud recherche(Noeud a, int x){
        if(a == null) return null;
        if (x==a.contenu()) return a;
        else if(a.contenu()>x){
            return recherche(a.gauche,x);
        }
        else{
            return recherche(a.droit,x);
        }
    }
    public boolean recherche(int x){
        return recherche( this.racine, x) != null;
    }

    public static void main(String[] args){
        int[] t = new int[]{26,51,45,57,95,87,1,67};
        Arbre A = new Arbre();
        for (int i : t){
            A.inserer(i);
            afficherInfixe(A.Racine());
            System.out.println();
        }
        afficherInfixe(A.Racine());
        System.out.println();
        System.out.println(A.recherche(26));
        System.out.println(A.recherche(43));

    }
}
