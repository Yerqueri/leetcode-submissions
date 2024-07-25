class Solution {
    int count =0;
    public int findTargetSumWays(int[] nums, int target) {
        solve(nums,0,0,target);
        return count;
    }

    private void solve(int[] nums, int curr, int index, int target){
        if(index==nums.length){
            if(curr==target){
                count++;
            }
        }else{
            solve(nums,curr+nums[index], index+1, target);
            solve(nums,curr-nums[index], index+1, target);
        }
    }

}