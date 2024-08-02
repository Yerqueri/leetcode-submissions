class Solution {
    public int minSwaps(int[] nums) {
        int count =0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
        }
        int[] nums2 = new int[nums.length+count];
        for(int i=0;i<nums.length;i++){
            nums2[i] = nums[i];
        }
        for(int i=nums.length;i<nums2.length;i++){
            nums2[i] = nums[i-nums.length];
        }
        System.out.println(Arrays.toString(nums2));
        return findMin(nums2, count);
    }

    private int findMin(int[] data, int count) {
        int curr =0;
        for(int i=0;i<count;i++){
            curr+=data[i];
        }
        int min = count -curr;
        for(int i=count;i<data.length;i++){
            curr = curr - data[i-count] + data[i];
            min = Math.min(count-curr, min);
        }
        return min;
    }
}