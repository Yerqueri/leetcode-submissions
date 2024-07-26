class Solution {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for(int i=0;i<nums.length;i++){
            for(int j=31;j>=0;j--){
                arr[j]+=nums[i]&1;
                nums[i]=nums[i]>>>1;
            }
        }
        int sol =0;
        for(int i=0;i<32;i++){
            arr[i]=arr[i]%3;
            sol=(sol<<1)+arr[i];
        }
        return sol;

    }
}