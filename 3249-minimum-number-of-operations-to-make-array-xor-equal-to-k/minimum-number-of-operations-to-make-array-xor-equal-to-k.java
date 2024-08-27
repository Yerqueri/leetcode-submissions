class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = nums[0];
        for(int i=1;i<nums.length;i++){
            xor ^= nums[i];
        }
        int count =0;
        // System.out.println(Integer.toBinaryString(xor));
        // System.out.println(Integer.toBinaryString(k));
        while(xor>0 || k>0){
            if((k&1) != (xor&1)){
                count++;
            }
            k=k>>1;
            xor=xor>>1;
        }
        return count;
    }
}