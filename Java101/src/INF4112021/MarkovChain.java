package INF4112021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class MarkovChain {
    // les triplets de mots consécutifs sont stockés dans une table
    static HashMap<Pair, Vector<String>> chains = new HashMap<>();

    // tirage aléatoire d'un élément dans une collection c
    static <E> E randomElement(Collection<E> c) {
        int n = (int) (Math.random() * c.size());
        for (E x : c)
            if (n-- == 0)
                return x;
        assert false; // ne doit pas arriver
        return null;
    }

    // tirage aléatoire dans un vecteur (plus simple)
    // ici on sait que v contient au moins un élément
    static String randomElement(Vector<String> v) {
        assert v.size() > 0;
        int n = (int) (Math.random() * v.size());
        return v.get(n);
    }
    // lecture du fichier (suppose qu'il contient au moins deux mots)
    static void readFile(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        String w1 = sc.next();
        String w2 = sc.next();
        Pair p = new Pair(w1, w2);
        int count = 0;
        while (sc.hasNext()) {
            count ++;
            String w3 = sc.next();
            Vector<String> l = chains.get(p);
            if (l == null)
                chains.put(p, l = new Vector<String>());
            l.add(w3);
            p = new Pair(p.snd, w3);
        }
        System.out.println("nombre de mots: "+count);
        sc.close();
    }
    /* génération du texte
     * note : on fait un effort pour ne pas écrire des lignes trop longues
     */
    static void generateText(Pair p, int words) {
        System.out.print(p.fst + " " + p.snd + " ");
        words -= 2;
        int column = p.fst.length() + p.snd.length() + 2;
        while (words-- > 0) {
            Vector<String> l = chains.get(p);
            if (l == null) {
                System.out.println("+");
                return;
                // vraiment pas de chance
            }
            String s = randomElement(l);
            System.out.print(s + " ");
            column += s.length() + 1;
            if (column > 40) {
                System.out.println();
                column = 0;
            }
            p = new Pair(p.snd, s);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/INF4112021/luxun.txt");
        Pair p = randomElement(chains.keySet());
        generateText(p, 2000);
        System.out.println();
    }
}