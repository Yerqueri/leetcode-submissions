class Solution {
    public int maximumXOR(int[] nums) {
        int[] arr = new int[32];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<32;j++){
                if((nums[i] & 1)==1){
                    arr[j]=1;
                }
                nums[i]=nums[i]>>1;
            }
        }
        int num = 0;
        for(int i=31;i>=0;i--){
            num = num<<1;
            num = num|arr[i];
        }
        return num;
    }
}

// 0011
// 0010
// 0100
// 0110
// ----
// 0111

// 0001
// 0010
// 0011
// 1001
// 0010
// ----
// 1011