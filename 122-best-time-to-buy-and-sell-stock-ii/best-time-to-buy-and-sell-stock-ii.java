class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        for(int i=1;i<prices.length;i++){
            int curr = prices[i]-prices[i-1];
            if(curr>=0){
                profit+=curr;
            }
        }
        return profit;
    }
}