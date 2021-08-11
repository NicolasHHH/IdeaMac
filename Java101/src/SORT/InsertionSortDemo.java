package SORT;

import edu.princeton.cs.algs4.*;

import java.util.Comparator;

public class InsertionSortDemo {
    // constructeur
    private InsertionSortDemo(){}
    private static int exh = 0;

    public static void sort(Comparable[] a) {
        exh = 0;
        StdOut.println("ver Insert 0.9");
        int n = a.length;
        sort(a,0, n);
        StdOut.println(exh);
    }
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
                exh++;
            }
            //show(a);
        }
        assert isSorted(a, lo, hi);
    }


    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i]);
            StdOut.print(" ");
        }
        StdOut.println(" ");
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }
    private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i-1], comparator)) return false;
        return true;
    }

    public static void main(String[] args) {
        //String[] b = StdIn.readAllStrings();
        Comparable<Integer>[] a = new Comparable[100];
        for (int i=0;i<100;i++) {
            a[i] = 130-i;
        }
        StdRandom.shuffle(a);
        InsertionSortDemo.sort(a);
        show(a);
    }

}
