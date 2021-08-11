package LeetCode;


// exceed space limit
public class LC042_Raindrop {
    public static int trap(int[] height) {
        int highest = 0;
        int count = 0;
        for(int i:height){
            if (i > highest)
                highest = i;
        }
        int len = height.length;
        int[][] dp = new int[highest+1][len+2];
        for (int j = 0; j < len+2; j++ ) {
            dp[0][j] = 2;
        }
        for (int j = 1; j < len+1; j++ ){
            int hauteur = height[j-1];
            if (hauteur>0){
                for (int h = 1; h < hauteur+1; h++){
                    dp[h][j] = 2;
                }
            }
        }
        int note = 0;
        for (int i = 1; i < highest+1;i++){
            for(int j = 1; j < len+1; j++){
                if (dp[i][j-1]>1 && dp[i-1][j]>=1 && dp[i][j]==0){
                    if( dp[i][j+1]>=1) {
                        count ++;
                        dp[i][j]=1;
                    }
                    else note = j;
                }
                if (note!=0 && dp[i][j+1]==2 && dp[i-1][j]>=1 && dp[i][j]==0 && dp[i-1][j]>=1) {
                    for(int k = note; k<=j;k++){
                        dp[i][k]=1;
                        count ++;
                    }
                    note = 0;
                }
            }
            note = 0;
        }

        return count;
    }

    public static void imprimer(int[][] grid){
        for(int[] row : grid){
            for(int col : row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] t = {4,2,0,3,2,5};
        trap(t);
    }
}
