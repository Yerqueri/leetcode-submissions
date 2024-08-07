class Solution {
    public int[] singleNumber(int[] nums) {
        int xor =0;
        for(int i : nums){
            xor ^= i;
        }
        int mask = xor & (-xor);
        int n1 = 0;
        for(int i: nums){
            if((i & mask) == mask){
                n1^=i;
            }
        }
        return new int[]{n1,xor^n1};
    }
}