class Solution {
    Set<List<Integer>> sol;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<Integer> usedIndexes = new HashSet<>();
        sol = new HashSet<>();
        solve(nums,new HashSet<>(),new ArrayList<>());
        return new ArrayList<>(sol);

    }

    private void solve(int[] nums, Set<Integer> usedIndexes, List<Integer> temp){
        if(usedIndexes.size()==nums.length){
            sol.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(!usedIndexes.contains(i)){
                    usedIndexes.add(i);
                    temp.add(nums[i]);
                    solve(nums,usedIndexes,temp);
                    temp.remove(temp.size()-1);
                    usedIndexes.remove(i);
                }
            }
        }
    }
}