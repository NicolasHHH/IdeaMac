package StackTest;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class HillDemo {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
    }
    public static void main(String args[]){
        Comparable[] arr = {1,2,3,4,5,6};
        sort(arr);
        StdOut.println(arr[0]);
        exch(arr,0,2);
        StdOut.println(arr[0]);
        StdOut.println(less(1,2));
        StdOut.println(less(3,2));
        StdOut.println(less(1,1));
    }

    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}

