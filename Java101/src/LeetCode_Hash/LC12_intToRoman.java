package LeetCode_Hash;

import java.util.HashMap;

public class LC12_intToRoman {
    public static String intToRoman(int num) {
        String s = "";
        HashMap<Integer,String> hm = new HashMap<>(7);
        hm.put(1,"I");
        hm.put(4,"IV");
        hm.put(5,"V");
        hm.put(9,"IX");
        hm.put(10,"X");
        hm.put(40,"XL");
        hm.put(50,"L");
        hm.put(90,"XC");
        hm.put(100,"C");
        hm.put(400,"CD");
        hm.put(500,"D");
        hm.put(900,"CM");
        hm.put(1000,"M");

        int[] romans = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int x: romans) {
            int rest = num % x;
            for (int i = 0; i < num / x; i++) {
                s += hm.get(x);
            }
            num = rest;
        }
        return s;
    }









    public static void main (String[] args){
        System.out.println(intToRoman(39));

    }
}

