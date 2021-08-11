package INF3612020;

public interface Element {
    public final static int SMALLER = -1;
    public final static int EQUAL = 0;
    public final static int LARGER = 1;
    public int comparerA(Element v);
    public String toString();
}
