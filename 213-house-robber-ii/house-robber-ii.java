class Solution {
    Integer[][] dp;
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }else{
            Integer[][] dp = new Integer[3][nums.length];
            return Math.max(rob(nums,0,0, dp),Math.max(rob(nums,1,1,dp),rob(nums,2,2,dp)));
        }
    }

    private int rob(int[] nums, int curr, int start, Integer[][] dp){
        if(start==0 && curr==nums.length-1 || curr>=nums.length){
            return 0;
        }else if(dp[start][curr]!=null){
            return dp[start][curr];
        }else{
            int current = nums[curr]+rob(nums,curr+2,start,dp);
            int next = rob(nums, curr+1,start,dp);
            dp[start][curr] = Math.max(current,next);
            return dp[start][curr];
        }
    }
}