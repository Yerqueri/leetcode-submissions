class Solution {
    Integer[] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length];
        int max = 0;
        for(int i=0;i<prices.length;i++){
            if(dp[i]==null){
                calculate(i,prices);
            }
            max = Math.max(max, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        return max;
    }

    private int calculate(int start, int[] prices){
        if(start>=prices.length){
            return 0;
        }else if(dp[start]!=null){
            return dp[start];
        }else{
            int max =0;
            for(int i=start+1;i<prices.length;i++){
                // use start in trasaction
                max = Math.max(max,prices[i]-prices[start]+calculate(i+2,prices));
                // skip start for a transaction
                max = Math.max(max,calculate(start+1,prices));
            }
            dp[start]=max;
            return dp[start];
        }
    }
}