class Solution {
    public int findMin(int[] nums) {
        int l =-1;
        int r =nums.length;
        while(l+1<r){
            int mid = (l+r)/2;
            if(nums[mid]>=nums[0]){
                l=mid;
            }else{
                r=mid;
            }
        }
        if(r==nums.length){
            return nums[0];
        }
        return nums[r];
    }
}