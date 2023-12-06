class Solution {
    public int maxProfit(int[] prices) {
        int currMax =0;
        int maxProfit =0;
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>currMax){
                currMax = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, currMax-prices[i]);
            }
        }
        return maxProfit;
    }
}