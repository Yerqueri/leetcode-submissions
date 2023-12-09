class Solution {

    public int minimumSplits(int[] nums) {
        int count =0;
        int curr = nums[0];
        for(int i=1;i<nums.length;i++){
            curr = gcd(curr,nums[i]);
            if(curr==1){
                count++;
                curr = nums[i];
            }
        }
        return count+1;
    }

    private int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}