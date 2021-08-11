package StackTest;

import edu.princeton.cs.algs4.StdOut;

public class DateCompare implements Comparable<DateCompare> {
    private final int month, day, year;

    public DateCompare(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }
    public int compareTo(DateCompare that){

        if (this.year < that.year) return -1;
        if (this.year < that.year) return 1;
        if (this.month < that.month) return -1;
        if (this.month < that.month) return 1;
        if (this.day < that.day) return -1;
        if (this.day < that.day) return 1;
        return 0;
    }

    public static void main(String[] args){
        DateCompare d1 = new DateCompare(12,6, 1999);
        DateCompare d2 = new DateCompare(11,11,2000);

        StdOut.println(d1.compareTo(d2));
    }

}
