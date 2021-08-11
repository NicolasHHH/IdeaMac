package INF3612020;

public class ChaineElt implements Element{
    private String Clef;
    public ChaineElt(String s){
        this.Clef = s;
    }
    public String toString(){
        return this.Clef ;
    }
    public int comparerA(Element v){
        int cmp = this.Clef.compareTo(((ChaineElt) v).Clef);
        if ( cmp<0 ) {
            return Element.SMALLER;
        }
        else if(cmp == 0){

            return Element.EQUAL;
        }
        else
            return Element.LARGER;
    }

    public static void main(String[] args){
        ChaineElt ct = new ChaineElt("Utilisation interface");
        ChaineElt ct2 = new ChaineElt("Utilisation");
        ChaineElt ct3 = new ChaineElt("Interface");
        System.out.println(ct.toString());
        System.out.println(ct.comparerA(ct2));
        System.out.println(ct.comparerA(ct3));
    }
}
