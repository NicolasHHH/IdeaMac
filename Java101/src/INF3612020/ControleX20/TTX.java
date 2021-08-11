package INF3612020.ControleX20;

import edu.princeton.cs.algs4.EdgeWeightedGraph;

public class TTX {
    public final String destination ;
    public Wagon tete;

    public TTX(String d,Wagon w){
        this.destination = d;
        this.tete = w;
    }

    public String toString(){
        String res = this.destination + " : ";
        res += Wagon.chaineDe(this.tete);
        return res;
    }

    public boolean estCorrect(){
        // baggages à la fin

        boolean ok = false;
        return ok;

    }

    public static void main(String[] args){
        TTX ttx1 = new TTX("Palaiseau", Wagon.exempleTrain());
        System.out.println(ttx1);
    }
}
