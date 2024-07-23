class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = makeDp(matrix);
        int max =0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                int top = i-1>=0 ? dp[i-1][j] : 0;
                int left = j-1>=0 ? dp[i][j-1] : 0;
                int tl = i-1>=0 && j-1>=0?dp[i-1][j-1]:0;
                if(dp[i][j]==1){
                    dp[i][j] += Math.min(tl,Math.min(top,left));
                }
                max = Math.max(max,dp[i][j]);
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        return max*max;
    }

    private int[][] makeDp(char[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                dp[i][j] = matrix[i][j]=='0'?0:1;
            }
        }
        return dp;
    }
}