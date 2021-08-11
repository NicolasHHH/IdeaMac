package INF3612020.Controle;

import java.util.LinkedList;
public class JListe{
    private LinkedList<Integer> L;
    public JListe(){ this.L = new LinkedList<Integer>(); }
    public boolean estVide(){ return this.L.isEmpty(); }
    public void ajouteEnTete(int x){ this.L.addFirst(x); }
    public int enleveEnTete(){ return this.L.removeFirst(); }
    public int valeurTete(){ return this.L.getFirst(); }
    public void ajouteEnQueue(int x){ this.L.addLast(x); }
    public int enleveEnQueue(){ return this.L.removeLast(); }
    public int valeurQueue(){ return this.L.getLast(); }
    public void partageListe(JListe j0){
        this.L = j0.L;
    }

    public JListe(int x){
        this.L = new LinkedList<Integer>();
        ajouteEnTete(x);
    }

    public String toString(){
        String s = "[";
        for(Integer X : this.L){
            if(s.length() > 1)
                s += " ";
            s += X;
        }
        return s + "]";
    }

}
