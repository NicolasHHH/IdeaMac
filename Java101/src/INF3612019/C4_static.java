package INF3612019;

import java.awt.*;
class Produit{
    public String nom;
    public int nb;
    public double prix;
}


public class C4_static {

    public int abs, ord;
    public Produit stock;

    public static int nbPoints = 0;
    public C4_static(){
        stock = new Produit();
        stock.prix = 30;
        nbPoints++;
    }
    public static void main(String[] args){
        C4_static P = new C4_static();
        C4_static Q = new C4_static();
        System.out.println(P.stock.prix) ;
        System.out.println(nbPoints);
        System.out.println("version 2");
    }
}
