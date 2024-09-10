class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int max =0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-k)){
                max = Math.max(max, i-map.get(nums[i]-k));
            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(map);
        return max;
    }
}