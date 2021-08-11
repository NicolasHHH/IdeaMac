package INF3612020.Controle;

public class BlocBC {
    final public TransactionBC t;
    final public long hash;
    public BlocBC(TransactionBC t, long hash){
        this.t = t;
        this.hash = hash;
    }

}
