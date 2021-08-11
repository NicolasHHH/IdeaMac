package INF3612020.ExpressPack;

import java.util.LinkedList;

public class Lecteur {
    // le tableau des caractères
    private char[] T;
    // index du prochain caractère à lire
    private int index;
    private  int len;
    public Lecteur(String s){
        this.T = s.toCharArray();
        this.index = 0;
        this.len = this.T.length;
    }
    // vérifier si on est arrivé à la fin
    public boolean fini(){
        return this.index >= this.len;
    }
    public char caractereCourant(){
        return this.T[this.index];
    }
    public char caractereSuivant(){
        return this.T[this.index++];
    }
    public void Suivant(){
        this.index++;
    }

    public static void etat_i(LinkedList<String> l, Lecteur L){
        if(!L.fini()){
            if(Character.isSpaceChar(L.caractereCourant())){
                L.Suivant();
                etat_i(l, L);
            }
            else etat_l(l, L);
        }

    }
    public static void etat_l(LinkedList<String> l, Lecteur L){
        String mot = "" + L.caractereSuivant();
        while(!L.fini()){
            if(Character.isSpaceChar(L.caractereCourant()))
                break;
            else
                mot += L.caractereSuivant();
        }
        l.addLast(mot);
        etat_i(l, L);
    }

    public static void main(String[] args){
        String s = "il faut ce qu'il faut.";
        Lecteur L = new Lecteur(s);
        LinkedList<String> ls = new LinkedList<>();
        etat_i(ls,L);
        ls.peek();
        System.out.println(ls.toString());
    }
}
