class Solution {
    public int minSwaps(int[] nums) {
        int count =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            count+=nums[i];
        }

        int curr = 0;

        int min = count;

        for(int i=0;i<n+count+1;i++){
            if(i<count){
                curr+=nums[i];
            }else{
                min = Math.min(count-curr, min);
                if(i<n+count){
                    curr -= nums[i-count];
                    curr += nums[i%n];
                }
            }
        }
        return min;
    }
}