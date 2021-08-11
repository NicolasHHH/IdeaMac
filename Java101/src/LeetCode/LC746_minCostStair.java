package LeetCode;

public class LC746_minCostStair {
    public static int minCostClimbingStairs(int[] cost) {
        int cout = 0;
        int len = cost.length;
        int debut = len-1;
        if (cost[len-1]>=cost[len-2]){
            cout += cost[len-2];
            debut = len-2;
        }
        else cout += cost[len-1];

        for (int i = debut ; i>=2;i--){
            if (cost[i-2]>=cost[i-1]){
                cout += cost[i-1];
            }
            else {
                cout+= cost[i-2];
                --i;
            }
        }
        return cout;
    }

    public static int minCostClimbingStairs2(int[] cost) {
        int len = cost.length;
        for (int i = 2 ; i < len;i++){
            if (cost[i-1]<cost[i-2]){
                cost[i] += cost[i-1];
            }
            else {
                cost[i] += cost[i-2];
            }
        }
        if (cost[len-1]<cost[len-2]){
            return cost[len-1];
        }
        else return cost[len-2];
    }

    public static void main(String[] args){
        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] b = {1,100,1};
        int[] c = {0,1,1,1};
        System.out.println(minCostClimbingStairs2(a));
        System.out.println(minCostClimbingStairs2(b));
        System.out.println(minCostClimbingStairs2(c));

    }
}
