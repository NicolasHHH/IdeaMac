package LeetCode;

public class LC005_Palindrome {
    public static boolean checkPalindrome(String s){
        int len = s.length();
        if (len != 0){
            for (int i = 0; i < len/2+1;i++){
                if (s.charAt(i)!=s.charAt(len-i-1)){
                    return false;
                }
            }
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        int longeur = 0;
        int len = s.length();
        for (int l = len; l >= 0 ; l--){
            for (int i = 0; i+l<len ; i++){
                if (checkPalindrome(s.substring(i,i+l+1))){
                    return s.substring(i,i+l+1);
                }
            }
        }
        return "";
    }
    public static void main(String[] args){
        String s1 = "aa";
        System.out.println(longestPalindrome(s1));
        String s2 = "a";
        System.out.println(longestPalindrome(s2));
        String s3 = "ab";
        System.out.println(longestPalindrome(s3));
        String s4 = "cbbd";
        System.out.println(longestPalindrome(s4));
        String s5 = "babad";
        System.out.println(longestPalindrome(s5));
    }
}
