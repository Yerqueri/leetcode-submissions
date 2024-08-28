class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums1.length > nums2.length * 6) {
            return -1;
        }
        int sum1 = 0;
        for(int i:nums1){
            sum1+=i;
        }
        int sum2 =0;
        for(int i:nums2){
            sum2+=i;
        }
        if(sum1>sum2){
            return minOperations(nums2,nums1);
        }else{
            int[] arr = new int[7];
            for(int i=0;i<nums1.length;i++){
                int n = nums1[i];
                arr[6-n]++;
            }
            for(int i=0;i<nums2.length;i++){
                int n = nums2[i];
                arr[n-1]++;
            }
            System.out.println(Arrays.toString(arr));
            int i =5;
            int count =0;
            while(sum1<sum2){
                while(arr[i]==0){
                    i--;
                }
                sum1+=i;
                arr[i]--;
                count++;
            }
            return count;
        }
    }
}