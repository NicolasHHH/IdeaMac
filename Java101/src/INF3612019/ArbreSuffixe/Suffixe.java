package INF3612019.ArbreSuffixe;

import java.util.LinkedList;

public class Suffixe {
    public char ch;
    public LinkedList<Suffixe> suffixes;
    public Suffixe(char c){
        this.ch = c;
        this.suffixes = new LinkedList<Suffixe>();
    }
    public void ajouterBranche(String mot,int i){
        Suffixe suf = this;
        for (; i<mot.length();i++){
            Suffixe s = new Suffixe(mot.charAt(i));
            suf.suffixes.add(s);
            suf = s; // move to next
        }
        suf.suffixes.add(new Suffixe('#'));
    }
    public void inserer(String mot,int i){
        Suffixe suf = this;
        // si fini, on ajoute un dièze
        if ( i == mot.length()){
            suf.suffixes.add(new Suffixe('#'));
            return;
        }
        for(Suffixe s : suf.suffixes){
            if (s.ch == mot.charAt(i) ){
                s.inserer(mot,i+1);
                return;
            }
        }
        // si le mot coincide jamais avec les contenus, créer une nouvelle branche
        suf.ajouterBranche(mot,i);
    }
    public void inserer(String mot){
        this.inserer(mot,0);
    }
    public static void afficherMots(Suffixe suf, String buf){
        if (suf.ch == '#')
            System.out.println(buf);
        // 自带深度遍历 递归拼接词语
        else for(Suffixe s: suf.suffixes){
            System.out.println("s :"+s.ch+" "+buf);
            afficherMots(s,buf+s.ch);
        }
    }
}
