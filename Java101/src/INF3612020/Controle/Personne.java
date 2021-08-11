package INF3612020.Controle;

import java.util.LinkedList;

public class Personne{
        public String nom;
        public Personne chef;
        public LinkedList<Personne> subordonnes;
        public Personne(String n, Personne c){
                this.nom = n;
        }
        public static void afficher(Personne p){ afficher(p, 0);
        }
        public static void afficher(Personne p, int nblancs){
                if(p == null) return;
                for(int i = 0; i < nblancs; i++)
                        System.out.print(" ");
                System.out.println(p.nom);
                for(Personne s : p.subordonnes)
                        afficher(s, nblancs+2);
        }
        public static Personne chefSupreme(Personne p){
                if(p == null) return null;
                if(p.chef == null) return p;
                else return chefSupreme(p.chef);
        }
        public static void listeChefs(LinkedList<Personne> l, Personne p){
                if(p != null){
                        l.addFirst(p);
                        listeChefs(l, p.chef);
                }
        }
        public static LinkedList<Personne> listeChefs(Personne p){
                LinkedList<Personne> l = new LinkedList<Personne>();
                listeChefs(l, p.chef);
                return l;
        }
}

