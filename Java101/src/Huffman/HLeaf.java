package Huffman;

import java.util.Map;

public class HLeaf extends HHuffmanTree{
    public final char c;
    HLeaf(char c){
        this.c = c;
        this.freq = 0;
    }
    void traverse(String prefix, Map<Character, String> m) {
        m.put(this.c, prefix);
    }
    char find(String s, int i) {
              return this.c;
    }
}
