class Solution {
    public int maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            max = Math.max(max, nums[i]);
            right[i]=max;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        max = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            Integer l = treeSet.floor(nums[i]-1);
            int r = right[i+1];
            if(l!=null && nums[i]<r){
                max = Math.max(max, l+r-nums[i]);
            }
            treeSet.add(nums[i]);
        }
        return max;
    }
}
