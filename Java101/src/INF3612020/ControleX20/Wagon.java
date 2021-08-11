package INF3612020.ControleX20;

public class Wagon {
    static final String TYPE_A = "affaire"; // 20
    static final String TYPE_B = "baggage";  //0
    static final String TYPE_E = "eco"; //50

    private final int serie;
    public static int temp = 0;
    public final String type; // "affaire" "eco" "baggage"
    public Wagon suivant;


    public Wagon(String type){
        this.serie = ++temp;
        this.type = type;
        this.suivant = null;
    }
    public String toString(){
        String res = "Wagon_"+this.serie+"__type = ";
        res += this.type;
        return res;
    }
    public static Wagon exempleTrain(){
        temp = 0;
        Wagon t = new Wagon("eco");
        t.suivant = new Wagon("affaire");
        t.suivant.suivant = new Wagon("baggage");
        return t;
    }

    public static String chaineDe(Wagon t){
        String res = "[" + t.toString();
        res += "] -> ";
        if (t.suivant != null){
            res +=  chaineDe(t.suivant);
        }
        else{
            res += "[]";
        }
        return res;
    }

    public static int capacite(Wagon w){
        int capa = 0;
        while(w!=null){
            switch (w.type){
                case TYPE_A: capa += 20;break;
                case TYPE_B: capa += 0;break;
                case TYPE_E: capa += 50; break;
            }
            w = w.suivant;
        }
        return capa;
    }
    public static Wagon accrocher(Wagon t1, Wagon t2){
        if (t1 == null){
            return t2;
        }
        else {
            Wagon z = t1;
            while (z.suivant != null) {
                z = z.suivant;
            }
            z.suivant = t2;
            return t1;
        }
    }

    public static void main(String[] args){
        Wagon w1 = new Wagon("affaire");
        Wagon w2 = new Wagon("eco");
        w1.suivant = w2;
        System.out.println(w1);

        System.out.println();

        Wagon train = exempleTrain();
        System.out.println(chaineDe(train));
        System.out.println(capacite(train));
        System.out.println(chaineDe(accrocher(train,w1)));
    }


}
