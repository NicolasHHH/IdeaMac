package Huffman;

import java.util.Map;

abstract class HHuffmanTree implements Comparable<HHuffmanTree> {
    int freq;
    public int compareTo(HHuffmanTree that){
        return this.freq - that.freq;
    }
    abstract void traverse(String prefix, Map<Character, String> m);
    abstract char find(String s, int i);
}
