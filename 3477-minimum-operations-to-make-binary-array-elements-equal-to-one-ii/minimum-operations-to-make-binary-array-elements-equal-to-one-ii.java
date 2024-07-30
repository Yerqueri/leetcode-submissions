class Solution {
    public int minOperations(int[] nums) {
        boolean flipped = false;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && !flipped){
                count++;
                flipped = !flipped;
            }else if(nums[i]==1 && flipped){
                count++;
                flipped = !flipped;
            }
        }
        return count;
    }
}