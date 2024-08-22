class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count =1;
        int max = 1;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                count++;
            }else if(nums[i]==nums[i-1]){
                continue;
            }else{
                count =1;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}