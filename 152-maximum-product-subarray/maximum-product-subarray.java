class Solution {
    public int maxProduct(int[] nums) {
        int max_pos = 1;
        int min_neg = 1;
        int sol = nums[0];
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            int temp_max = Math.max(val, Math.max( max_pos*val, min_neg*val));
            min_neg = Math.min(val, Math.min( max_pos*val, min_neg*val));
            max_pos = temp_max;
            //System.out.println(max_pos+" "+min_neg);
            sol = Math.max(max_pos,sol);
        }
        return sol;
    }
}