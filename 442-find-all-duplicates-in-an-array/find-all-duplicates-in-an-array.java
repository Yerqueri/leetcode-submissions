class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0){
                sol.add(Math.abs(nums[i]));
            }else{
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        return sol;
    }
}