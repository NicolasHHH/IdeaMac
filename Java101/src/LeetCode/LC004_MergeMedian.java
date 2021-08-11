package LeetCode;

public class LC004_MergeMedian {
    public double median(int[] nums){
        int len = nums.length;
        if ( len%2==0)
            return nums[len/2];
        else
            return (nums[len/2]+nums[len/2+1])/2;
    }
    public int[] merge(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] res = new int[l1+l2];
        int j=0,k=0;
        for (int i = 0; i<l1+l2;i++){
            if (j==l1){
                res[i] = nums2[k++];
            }
            else if(k==l2){
                res[i] = nums1[j++];
            }
            else {
                if(nums1[j]<nums2[k]) res[i] = nums1[j++];
                else res[i] = nums2[k++];
            }
        }
        return res;
    }
}
