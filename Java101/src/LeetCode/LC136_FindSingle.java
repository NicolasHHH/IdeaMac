package LeetCode;

public class LC136_FindSingle {

        public static int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }


    public static void main(String[] args){
        System.out.println(7^2);
        int[] t = {5,3,6,2,8,5,3,6,8};
        System.out.println(singleNumber(t));
    }
}
