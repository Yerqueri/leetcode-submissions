class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i];
            if(left[i]==0){
                break;
            }
        }
        int[] right = new int[nums.length];
        right[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            right[i]=right[i+1]*nums[i];
            if(right[i]==0){
                break;
            }
        }

        for(int i=0;i<nums.length;i++){
            int l = i-1>=0 ? left[i-1] :1;
            int r = i+1<nums.length ? right[i+1] :1;
            nums[i] = l*r;
        }
        return nums;
    }
}