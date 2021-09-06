package INF4112021;

import java.util.HashMap;

public class amphi2 {

// étant donnée une matrice 15x15,
// sélectionner 15 éléments, un par ligne et par colonne,
// de façon à maximiser la somme


        final static int m[][] = {
                { 7, 53, 183, 439, 863, 497, 383, 563, 79, 973, 287, 63, 343, 169, 583 },
                { 627, 343, 773, 959, 943, 767, 473, 103, 699, 303, 957, 703, 583, 639, 913 },
                { 447, 283, 463, 29, 23, 487, 463, 993, 119, 883, 327, 493, 423, 159, 743 },
                { 217, 623, 3, 399, 853, 407, 103, 983, 89, 463, 290, 516, 212, 462, 350 },
                { 960, 376, 682, 962, 300, 780, 486, 502, 912, 800, 250, 346, 172, 812, 350 },
                { 870, 456, 192, 162, 593, 473, 915, 45, 989, 873, 823, 965, 425, 329, 803 },
                { 973, 965, 905, 919, 133, 673, 665, 235, 509, 613, 673, 815, 165, 992, 326 },
                { 322, 148, 972, 962, 286, 255, 941, 541, 265, 323, 925, 281, 601, 95, 973 },
                { 445, 721, 11, 525, 473, 65, 511, 164, 138, 672, 18, 428, 154, 448, 848 },
                { 414, 456, 310, 312, 798, 104, 566, 520, 302, 248, 694, 976, 430, 392, 198 },
                { 184, 829, 373, 181, 631, 101, 969, 613, 840, 740, 778, 458, 284, 760, 390 },
                { 821, 461, 843, 513, 17, 901, 711, 993, 293, 157, 274, 94, 192, 156, 574 },
                { 34, 124, 4, 878, 450, 476, 712, 914, 838, 669, 875, 299, 823, 329, 699 },
                { 815, 559, 813, 459, 522, 788, 168, 586, 966, 232, 308, 833, 251, 631, 107 },
                { 813, 883, 451, 509, 615, 77, 281, 613, 459, 205, 380, 274, 302, 35, 805 },
        };

        final static int n = m.length;

        // une classe pour mémoriser une somme
        private static class Solution {
            int total;
            int[] rows;

            Solution() {
                this.total = 0;
                this.rows = new int[n];
            }

            Solution(Solution s, int i, int j) {
                this.total = s.total + m[i][j];
                this.rows = new int[n];
                System.arraycopy(s.rows, 0, this.rows, 0, n);
                this.rows[i] = j;
            }
        }


        final static HashMap<Integer, Solution> memo = new HashMap<>();

        // à partir de la ligne i, avec les colonnes dans c
        static Solution f(int i, int c) {
            int key = (i << n) | c;
            Solution s = memo.get(key);
            if (s != null)
                return s;
            s = new Solution();
            if (i == n)
                return s;
            for (int j = 0; j < n; j++) {
                int col = 1 << j;
                if ((c & col) != 0) {
                    Solution r = f(i + 1, c - col);
                    if (m[i][j] + r.total > s.total)
                        s = new Solution(r, i, j);
                }
            }
            memo.put(key, s);
            return s;
        }

        public static void main(String[] args) {
            double start = System.currentTimeMillis();
            Solution s = f(0, (1 << n) - 1);
            System.out.print("solution = " + s.total + " = ");
            for (int i = 0; i < n; i++)
                System.out.printf("%d + ", m[i][s.rows[i]]);
            System.out.printf("0\n%2.2f ms\n", System.currentTimeMillis() - start);
        }

}

