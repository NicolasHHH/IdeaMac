package Huffman;


import java.util.*;

public class HHuffman {
    private HHuffmanTree tree;
    private Map<Character,String> codes;

    // Constructeur
    // On suppose que les fréquences d’apparition des différents caractères sont données ini- tialement,
    // sous la forme d’une collection de feuilles, c’est-à-dire d’une valeur alphabet de type Collection<Leaf>.

    HHuffman(Collection<HLeaf> alphabet) {
        if (alphabet.size() <= 1) throw new IllegalArgumentException();
        this.tree = buildTree(alphabet);
        this.codes = new HashMap<Character, String>();
        this.tree.traverse("", this.codes);
    }
    HHuffmanTree buildTree(Collection<HLeaf> alphabet) {
        HHeap<HHuffmanTree> pq = new HHeap<HHuffmanTree>();
        for (HLeaf l: alphabet)  pq.insert(l);
        while (pq.size() > 1) {
            HHuffmanTree left = pq.delMin();
            HHuffmanTree right = pq.delMin();
            pq.insert(new HNode(left, right));
        }
        return pq.getMin();
    }
    String encode(String msg) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < msg.length(); i++)
            sb.append(this.codes.get(msg.charAt(i)));
        return sb.toString();
    }
    String decode(String msg) { StringBuffer sb = new StringBuffer(); int i = 0;
        while (i < msg.length()) {
            char c = this.tree.find(msg, i); sb.append(c);
            i += this.codes.get(c).length();
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s = "abcdefghijklmn";
        Collection<HLeaf> feuilles = new ArrayList<>();
        for (int i = 0; i< s.length();i++){
            feuilles.add(new HLeaf(s.charAt(i)));
        }
        HHuffman Hfm = new HHuffman(feuilles);
        for (int i = 0; i< s.length();i++){
            System.out.println(Hfm.encode(s.substring(i,i+1)));
        }

        System.out.println(Hfm.decode("0"));
    }
}

