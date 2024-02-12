class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int i: nums){
            if(i==candidate){
                count++;
            }else if(count==0){
                candidate=i;
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}