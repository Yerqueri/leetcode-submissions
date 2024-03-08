class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int max = 0;
        for(int i:nums){
            arr[i]++;
            max = Math.max(max,arr[i]);
        }
        int val =0;
        for(int i:arr){
            if(i==max){
                val+=max;
            }
        }
        return val;
    }
}