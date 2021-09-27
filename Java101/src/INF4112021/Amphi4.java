package INF4112021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// Sudoku
public class Amphi4 {

    private int[] grid; // 0..80 (9 * row + col)

    Amphi4(String s) {
        this.grid = new int[81];
        for (int i = 0; i < 81; i++)
            this.grid[i] = s.charAt(i) - '0';
    }

    int row(int c) {
        return c / 9;
    }

    int col(int c) {
        return c % 9;
    }

    int group(int c) {
        return 3 * (row(c) / 3) + col(c) / 3;
    }

    boolean sameZone(int c1, int c2) {
        return row(c1) == row(c2) || col(c1) == col(c2) || group(c1) == group(c2);
    }

    // vérifie que la valeur dans c est compatible avec les autres cases
    boolean check(int c) {
        for (int i = 0; i < 81; i++)
            if (i != c && sameZone(c, i) && this.grid[c] == this.grid[i])
                return false;
        return true;
    }

    // entrée : suppose que grid ne contient pas de contradiction
    // sortie : true si grid a pu être complétée en une solution
    //          false si ce n’est pas possible et grid est inchangée
    boolean solve() {
        for (int c = 0; c < 81; c++)
            if (this.grid[c] == 0) {
                for (int v = 1; v <= 9; v++) {
                    this.grid[c] = v;
                    if (check(c) && solve())
                        return true;
                }
                this.grid[c] = 0;
                return false;
            }
        return true;
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0)
                System.out.println("+------+------+------+");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0)
                    System.out.print(" | ");
                System.out.print(this.grid[9 * i + j]);
            }
            System.out.println(" | ");
        }
        System.out.println("+------+------+------+");
    }

    public static void main(String[] args) throws FileNotFoundException {
        double start = System.currentTimeMillis();
        Amphi4 sk;

        sk = new Amphi4("200000060000075030048090100000300000300010009000008000001020570080730000090000004");
        sk.print();
        sk.solve();
        sk.print();
        System.out.println(((System.currentTimeMillis() - start) / 1000) + " s");
        // System.exit(0);

        Scanner sc = new Scanner(new File("sudoku.txt"));
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println("s = " + s);
            Amphi4 sks = new Amphi4(s);
            // sks.print();
            System.out.println();
            if (sks.solve())
                sks.print();
            else
                System.out.println("pas de solution");
            System.out.println();
        }
        sc.close();
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }
}