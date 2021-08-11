package INF3612020.Controle;

public class TransactionBC {
    final private ClientBC c1, c2;
    final private int montant;
    public TransactionBC(ClientBC c1, ClientBC c2, int m){
        this.c1 = c1;
        this.c2 = c2;
        this.montant = m;
    }
    public void executer(){
        this.c1.ajouteMontant(-this.montant);
        this.c2.ajouteMontant(this.montant);
    }
}
