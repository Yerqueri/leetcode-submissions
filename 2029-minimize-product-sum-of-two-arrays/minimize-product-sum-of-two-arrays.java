class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=nums1[i]*nums2[n-i-1];
        }
        return sum;
    }
}