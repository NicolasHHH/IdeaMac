package INF3612020.Controle;

public class ClientBC {
    final private String nom;
    private int solde;
    public ClientBC(String n, int s){
        this.nom = n;
        this.solde = s;
    }
    public void ajouteMontant(int m){
        this.solde += m;
    }
}
