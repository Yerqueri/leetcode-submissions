class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count =0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                int currTarget = target-sum;
                int index = binarySearch(nums,currTarget,j);
                if(index>j){
                    count+=index-j;
                }
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int target, int start){
        int end = nums.length;
        while(start+1<end){
            int mid = (start+end)>>1;
            if(nums[mid]<target){
                start=mid;
            }else{
                end=mid;
            }
        }
        return start;
    }
}