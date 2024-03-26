class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i =1;i<nums.length;i++){
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                //System.out.println("before: "+i+" "+Arrays.toString(nums));
                swap(nums,i);
                //System.out.println("after: "+i+" "+Arrays.toString(nums));
                i--;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    private void swap(int[] nums, int i){
        int val = nums[i];
        int swapIndex = nums[i]-1;
        int val2 = nums[nums[i]-1];
        nums[i]=val2;
        nums[swapIndex] = val;
    }
}
