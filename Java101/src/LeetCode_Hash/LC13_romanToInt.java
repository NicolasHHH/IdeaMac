package LeetCode_Hash;


import java.util.HashMap;

public class LC13_romanToInt {
    public static int romanToInt(String s) {
        int sum = 0;
        HashMap<String,Integer> hm = new HashMap<>(7);
        hm.put("I",1);
        hm.put("IV",4);
        hm.put("V",5);
        hm.put("IX",9);
        hm.put("X",10);
        hm.put("XL",40);
        hm.put("L",50);
        hm.put("XC",90);
        hm.put("C",100);
        hm.put("CD",400);
        hm.put("D",500);
        hm.put("CM",900);
        hm.put("M",1000);

        String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int end = s.length();
        for(String x: romans) {
            while (end-x.length()>=0 && x.compareTo(s.substring(end-x.length(),end))==0){
                sum += hm.get(x);
                //System.out.println(sum+"subs "+s.substring(end-x.length(),end));
                end = end - x.length();
                if (end-x.length()<0) break;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(romanToInt("MCMXCIV"));
    }
}
