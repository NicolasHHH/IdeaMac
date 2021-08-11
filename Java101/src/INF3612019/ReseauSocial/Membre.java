package INF3612019.ReseauSocial;

import java.util.*;
public class Membre {
    private String nom;
    private LinkedList<Membre> lamis;
    public Membre(String n){
        this.nom = n;
        this.lamis = new LinkedList<Membre>();
    }
    public String toString(){
        return this.nom;
    }
    public void ajouterAmitie(Membre b){
        this.lamis.add(b);
    }
    public void afficherAmities(){
        if (this.lamis.isEmpty()){
            System.out.println("n'a pas d'amis.");
        }
        else {
            System.out.println("Mes amis sont ");
            for ( Membre a : this.lamis){
                System.out.print( a+" ");
            }
            System.out.println();
        }
    }
}

