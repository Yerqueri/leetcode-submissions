class Solution {
    public int maximumTop(int[] nums, int k) {
        if(nums.length==1 && (k&1)==1){
            return -1;
        }
        int max = -1;
        for(int i=0;i<nums.length && i<k-1;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        if(k<nums.length){
            return Math.max(max,nums[k]);
        }
        return max;
    }
}


