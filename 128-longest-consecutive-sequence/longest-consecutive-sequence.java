class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max =1;
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            if(!set.contains(curr-1)){
                int streak =1;
                while(set.contains(curr+1)){
                    streak++;
                    curr++;
                }
                max = Math.max(max,streak);
            }
        }
        return max;
    }
}