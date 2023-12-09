class Solution {
    public long countSubarrays(int[] nums) {
        long[] dp = new long[nums.length];
        Arrays.fill(dp,1);
        long count =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                dp[i]=dp[i-1]+1;
            }
            count+=dp[i];
        }
        return count+1;
    }
}