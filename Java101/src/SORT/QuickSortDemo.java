package SORT;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;

public class QuickSortDemo {

    private QuickSortDemo(){}
    private static int exh = 0;

    public static void sortRapide(Comparable[] a) {
        exh = 0;
        StdOut.println("ver Quick 0.1");
        StdRandom.shuffle(a);
        sortRapide(a,0, a.length-1);
        StdOut.println(exh);
    }
    public static void sortRapide(Comparable[] a, int lo, int hi) {
        if (hi<=lo) return;
        int j = partition(a,lo,hi);
        sortRapide(a, lo,j-1);
        sortRapide(a,j+1, hi);

        assert isSorted(a, lo, hi);
    }
    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;
        while(true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
            exh++;
        }
        exch(a, lo, j);
        exh++;
        return j;
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
        QuickSortDemo.sortRapide(a);
        show(a);
    }
}
