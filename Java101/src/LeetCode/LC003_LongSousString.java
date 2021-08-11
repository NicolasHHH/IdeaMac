package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LC003_LongSousString {
    public static int lengthOfLongestSubstring(String s) {
        int retro = 0;
        int max = retro;
        for (int i = 0 ; i< s.length();i++){
            for (int j = i - 1; j >= 0 && j >= i-retro;j--){
                if (s.charAt(i) == s.charAt(j)){
                    retro = i-j-1;
                }
            }
            retro ++;
            if (retro > max){ max = retro;}
        }
        return max;
    }
    public static int lengthOfLongestSubstringCor(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            System.out.println("print"+i);
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    public static void main(String[] args){
        String s = "pwwkew";
        System.out.println(s.substring(3,5));
        System.out.println(lengthOfLongestSubstringCor(s));
        String s2 = "abcabcbb";
        System.out.println(lengthOfLongestSubstringCor(s2));
    }


}
