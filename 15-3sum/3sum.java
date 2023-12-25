class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        Set<List<Integer>> sol = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                //System.out.println(i+" "+j+" "+k+" "+nums[i]+" "+(nums[j]+nums[k]));
                if(-nums[i]>nums[j]+nums[k]){
                    j++;
                }else if(-nums[i]<nums[j]+nums[k]){
                    k--;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    sol.add(temp);
                    k--;
                }
            }
        }
        return new ArrayList<>(sol);
    }
}