class Solution {
    Integer[] dp = new Integer[50];
    
    public int climbStairs(int n) {
        if(n<=1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(dp[n]!=null){
            return dp[n];
        }else{
            dp[n] = climbStairs(n-1)+climbStairs(n-2);
            return dp[n];
        }
    }
}