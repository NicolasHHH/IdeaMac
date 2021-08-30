package INF4112021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;



    /* génération d'un texte aléatoire avec des chaînes de Markov
     *
     * utilisation: java Markov fichier n
     * où n est le nombre de mots du texte généré
     */

    /* les clés sont des paires de String */
    class StringPair {
        String fst, snd;

        StringPair(String fst, String snd) {
            this.fst = fst;
            this.snd = snd;
        }

        @Override // signifie une redéfinition
        public int hashCode() {
            return fst.hashCode() + snd.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            StringPair p = (StringPair) o;
            return this.fst.equals(p.fst) && this.snd.equals(p.snd);
        }
    }

    public class MarkovChains {

        // les triplets de mots consécutifs sont stockés dans une table
        static HashMap<StringPair, Vector<String>> chains = new HashMap<StringPair, Vector<String>>();

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
            StringPair p = new StringPair(w1, w2);
            while (sc.hasNext()) {
                String w3 = sc.next();
                Vector<String> l = chains.get(p);
                if (l == null)
                    chains.put(p, l = new Vector<String>());
                l.add(w3);
                p = new StringPair(p.snd, w3);
            }
            sc.close();
        }

        /* génération du texte
         * note : on fait un effort pour ne pas écrire des lignes trop longues
         */
        static void generateText(StringPair p, int words) {
            System.out.print(p.fst + " " + p.snd + " ");
            words -= 2;
            int column = p.fst.length() + p.snd.length() + 2;
            while (words-- > 0) {
                Vector<String> l = chains.get(p);
                if (l == null) return; // vraiment pas de chance
                String s = randomElement(l);
                System.out.print(s + " ");
                column += s.length() + 1;
                if (column > 70) {
                    System.out.println();
                    column = 0;
                }
                p = new StringPair(p.snd, s);
            }
        }

        public static void main(String[] args) throws FileNotFoundException {
            readFile("src/INF4112021/luxun.txt");
            StringPair p = randomElement(chains.keySet());
            generateText(p, 200);
            System.out.println();
        }


}
