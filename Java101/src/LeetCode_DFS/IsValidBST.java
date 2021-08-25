package LeetCode_DFS;


import java.util.Stack;

public class IsValidBST {
    static Stack<Integer> stk= new Stack<>();
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode lf, TreeNode rt){
            this.val = val;
            this.left = lf;
            this.right = rt;
        }

    }
    public static boolean isValid(TreeNode tn, long min, long max){
        if (tn == null) return true;
        else if (tn.val <= min || tn.val >= max){
            return false;
        }
        else return isValid(tn.left,min,tn.val) && isValid(tn.right,tn.val,max);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }


    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n2.left = n3;
        System.out.println(isValidBST(n2));
        System.out.println(isValidBST(n1));
        System.out.println(isValidBST(n3));
    }

}
