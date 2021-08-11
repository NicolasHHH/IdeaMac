package INF3612019.ReseauSocial;

import java.util.*;
import INF3612019.ReseauSocial.Membre;
public class ReseauSocial {
    private String nom;
    private HashMap<String, Membre> hm;
    public ReseauSocial(String n){
        this.nom = n;
        this.hm = new HashMap<String,Membre>();
    }
    public Membre deNom(String n){
        return this.hm.get(n);
    }
    public boolean estMembre(String nom){
        return this.hm.containsKey(nom);
    }
    public void creerMembre(String nom){
        if (! this.estMembre(nom)){
            this.hm.put(nom,new Membre(nom));
        }
    }
    public void ajouterAmitie(String nom_a,String nom_b){
        Membre a = this.hm.get(nom_a);
        Membre b = this.hm.get(nom_b);
        a.ajouterAmitie(b);
        b.ajouterAmitie(a);
    }
    public void afficherMembres(){
        for (Membre a : this.hm.values()){
            System.out.println(a);
        }
    }
    public void afficherAmities(){
        for ( Membre a : this.hm.values()){
            System.out.println(a+":");
            a.afficherAmities();
        }
    }
}
