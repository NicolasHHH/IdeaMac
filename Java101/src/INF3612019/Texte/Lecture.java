package INF3612019.Texte;

public class Lecture {

    private char[] T;
    private int index;

    public Lecture(String s){
        this.T = s.toCharArray(); // char to array
        this.index = 0; // pointer
    }
    public boolean fini() {
        return this.index >= this.T.length;
    }

    public char caractereCourant(){
        return this.T[this.index];
    }
    public char caractereSuivant(){
        return this.T[this.index++];
    }
    public static void afficher(String s) {
        Lecture L = new Lecture(s);
        while (!L.fini()) {
            System.out.println(L.caractereSuivant());
        }
    }

    public boolean bonType(char c){
        if (c=='M')
            return Character.isLetter(this.caractereCourant());
        else if(c=='N')
            return Character.isDigit(this.caractereCourant());
        else return false;
    }

    public String motSuivant(){
        while (!this.fini() && !this.bonType('M') ) // si ce n'est pas un char, on continue.
            this.caractereSuivant();
        if(this.fini())
            return null;
        else
            return this.lireMot();
    }
    public String lireMot(){
        String s = "";
        while (!this.fini() && this.bonType('M') ){
            s += this.caractereSuivant();
        }
        return s;
    }

    public String nombreSuivant(){
        while (!this.fini() && !this.bonType('N') ) // si ce n'est pas un char, on continue.
            this.caractereSuivant();
        if(this.fini())
            return null;
        else
            return this.lireNombre();
    }
    public String lireNombre(){
        String s = "";
        while (!this.fini() && this.bonType('N') ){
            s += this.caractereSuivant();
        }
        return s;
    }
}
