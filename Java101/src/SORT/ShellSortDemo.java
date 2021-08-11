package SORT;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;

public class ShellSortDemo {

    private ShellSortDemo(){}
    private static int exh = 0;

    public static void sort(Comparable[] a) {
        exh = 0;
        StdOut.println("ver 0.8");
        int n = a.length;
        int h = 1;
        while (h*3<n) {
            h = h*3+1;
        }
        while (h >= 1) {
            StdOut.println(h);
            hInsertSort(a,0, n, h);
            h = h/3;
        }
        StdOut.println(exh);
    }

    public static void hInsertSort(Comparable[] a, int lo, int hi, int h) {
        for (int i = lo + h; i < hi; i++) {
            for (int j = i; j -h >= lo && less(a[j], a[j-h]); j-=h) {
                exch(a, j, j-h);
                exh ++;
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
        //String[] a = StdIn.readAllStrings();
        Comparable<Integer>[] a = new Comparable[100];
        for (int i=0;i<100;i++) {
            a[i] = 120-i;
        }
        StdRandom.shuffle(a);
        ShellSortDemo.sort(a);
        show(a);

    }
}
