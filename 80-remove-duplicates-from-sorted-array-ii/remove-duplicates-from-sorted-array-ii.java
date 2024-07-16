class Solution {
    public int removeDuplicates(int[] nums) {
        int index =0;
        for(int i=0;i<nums.length;){
            int j =i+1;
            int count =1;
            while(j<nums.length && nums[i]==nums[j]){
                count++;
                j++;
            }
            for(int k =0;k<Math.min(count,2);k++){
                nums[index]=nums[i];
                index++;
            }
            i=j;
        }
        return index;
    }
}