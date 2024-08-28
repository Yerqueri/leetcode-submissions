class Solution {
    public int minimumCost(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int min = nums[1];
        for(int i=2;i<nums.length;i++){
            minSum = Math.min(minSum, nums[0]+nums[i]+min);
            min = Math.min(min, nums[i]);
        }
        return minSum;
    }
}