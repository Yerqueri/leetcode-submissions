class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum =0;
        for(int i : nums){
            sum+=i;
        }
        int curr =0;
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(sum - nums[i]- curr);
            sum -= nums[i];
            curr+= nums[i];
            nums[i] = val;
        }
        return nums;
    }
}