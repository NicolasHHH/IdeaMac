package Timing;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class StopWatchDemo {
    public static void main(String args[]) {
        var In = new In();
        //int[] a = In.readAllInts();
        int[] a = {1,2,3,4,5};
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(ThreeSum.count(a));
        double time = stopwatch.elapsedTime();
        StdOut.println(time);
    }
}
