package StackTest;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.ListIterator;

public class IterableDemo<Item> implements Iterable<Item> {

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

    public Iterator<Item> iterator() {return new ListIterator();}
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext() {return current!=null;}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        IterableDemo<Integer> intLink = new IterableDemo<Integer>();
        intLink.push(10);
        intLink.push(9);
        intLink.push(3);
        intLink.push(2);
        intLink.push(8);
        StdOut.println(intLink.iterator().hasNext());
        StdOut.println(intLink.iterator().next());



    }
}
