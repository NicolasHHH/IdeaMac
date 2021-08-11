package StackTest;

import edu.princeton.cs.algs4.StdOut;

public class GenericDemo<Item> {

    private Node first = null;
    private class Node{
        Item item;
        Node next;
    }
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }
    public void Imprimer() {
        while(first != null){
            StdOut.print(first.item);
            StdOut.print(" ");
            first = first.next;
        }
    }

    public static void main(String[] args) {
        GenericDemo<Integer> intLink = new GenericDemo<Integer>();

        intLink.push(10);
        intLink.push(9);
        intLink.push(3);
        intLink.push(2);
        intLink.push(8);
        StdOut.println(intLink.pop());
        intLink.Imprimer();
    }
}
