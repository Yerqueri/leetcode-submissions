class Solution {
    public int findPeakElement(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(i==1 && nums[i-1]>nums[i] ){
                return i-1;
            }else if(i==nums.length-1 && nums[i]>nums[i-1]){
                return i;
            }else if(nums[i-1]>nums[i] && nums[i-1]>nums[i-2]){
                return i-1;
            }
        }
        return 0;
    }
}