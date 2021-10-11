package Huffman;


import java.util.Map;

public class HNode extends HHuffmanTree {
    HHuffmanTree left,right;
    HNode(HHuffmanTree left, HHuffmanTree right){
        this.left = left;
        this.right = right;
        this.freq = left.freq + right.freq;
    }
    void traverse(String prefix, Map<Character, String> m) {
        this.left.traverse(prefix + '0', m);
        this.right.traverse(prefix + '1', m);
    }
    char find(String s, int i) { if (i == s.length())
        throw new Error("corrupted code; bad alphabet?");
        return (s.charAt(i) == '0' ? this.left : this.right).find(s, i+1);
    }
}
