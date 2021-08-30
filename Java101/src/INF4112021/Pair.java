package INF4112021;

public class Pair {
    String fst,snd;
    Pair(String fst,String snd){
        this.fst = fst ;
        this.snd = snd ;
    }
    private static int hashString(String s){
        int h = 0;
        for (int i = 0; i < s.length();i++){
            h = 31*h + s.charAt(i);
        }
        return h;
    }
    int hash(){
        return hashString(this.fst) + hashString(this.snd);
    }

    boolean equals( Pair p){
        return this.fst.equals(p.fst) && this.snd.equals(p.snd);
    }
    @Override
    public int hashCode(){
        return this.fst.hashCode() + this.snd.hashCode();
    }
}
