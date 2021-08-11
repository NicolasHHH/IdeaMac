package INF3612019.ArbreSuffixe;

public class ArbreSuffixes {
    private Suffixe racine;
    public ArbreSuffixes(){
        this.racine = new Suffixe('@');
    }
    public void inserer(String mot){
        this.racine.inserer(mot);
    }
    public void afficherMots(){
        Suffixe.afficherMots(this.racine,"");
    }
    public static void main(String[] args){
        String[] dico = new String[]{ "Jisoo", "Lisa", "Jennie", "Rose", "Lim","Jung"};
        ArbreSuffixes as = new ArbreSuffixes();
        for (String s: dico){
            as.inserer(s);
        }
        as.afficherMots();
    }
}
