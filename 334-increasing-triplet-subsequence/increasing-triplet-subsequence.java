class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] arr = new int[nums.length];
        arr[nums.length-1]=Integer.MIN_VALUE;
        for(int i=nums.length-2;i>=0;i--){
            arr[i] = Math.max(nums[i+1],arr[i+1]);
        }
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>min && nums[i]<arr[i]){
                return true;
            }
            min = Math.min(min,nums[i]);
        }
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(arr));
        return false;
    }
}