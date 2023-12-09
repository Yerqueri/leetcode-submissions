class Solution {
    Integer[][] dp;
    public int countVowelStrings(int n) {
        dp=new Integer[n][5];
        int sol =0;
        for(int i=0;i<5;i++){
            sol+=test(i,0,n-1);
        }
        return sol;
    }

    private int test(int curr, int length, int n){
        if(length==n){
            return 1;
        }else if(dp[length][curr]!=null){
            return dp[length][curr];
        }else{
            int count =0;
            for(int i=curr;i<5;i++){
                count+=test(i,length+1,n);
            }
            dp[length][curr] = count;
            return count;
        }
    }
}