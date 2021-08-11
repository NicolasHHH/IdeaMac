package LeetCode;

public class LC474_ZeroOne {
        public static int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (String s: strs) {
                int[] count = countzeroesones(s);
                for (int zeroes = m; zeroes >= count[0]; zeroes--)
                    for (int ones = n; ones >= count[1]; ones--)
                        dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
            }
            return dp[m][n];
        }

        public static int[] countzeroesones(String s) {
            int[] c = new int[2];
            for (int i = 0; i < s.length(); i++) {
                c[s.charAt(i)-'0']++;
            }
            return c;
        }

    public static void main(String[] args){
        //System.out.println(count("10001")[0]);
        //System.out.println(count("10001")[1]);
        //System.out.println(count("")[0]);
        String[] stri = {"111","1000","1000","1000"};
        System.out.println(findMaxForm(stri,9,3));

    }
}
