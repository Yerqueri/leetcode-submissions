class Solution {
    int n;
    Integer[][] dp;
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        this.n=n;
        dp = new Integer[n+1][n+1];
        return 1+count(1,1);
    }

    private int count(int prevcount, int curr){
        if(curr > n){
            return 10000;
        }else if(curr==n){
            return 0;
        }else if(dp[prevcount][curr]!=null){
            return dp[prevcount][curr];
        }else{
            int cp = 2+count(curr,curr*2);
            int p = 1+count(prevcount,curr+prevcount);
            dp[prevcount][curr] = Math.min(p,cp);
            return dp[prevcount][curr];
        }
    }
}