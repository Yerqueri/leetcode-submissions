class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        solve(candidates,new ArrayList<>(),0, target,0);
        return list;
    }

    private void solve(int[] candidates, List<Integer> temp, int sum, int target, int index){
        if(sum>target){
            return;
        }if(sum == target){
            list.add(new ArrayList<>(temp));
        }else{
            for(int j=index;j<candidates.length;j++){
                temp.add(candidates[j]);
                solve(candidates,temp, sum+candidates[j], target, j);
                temp.remove(temp.size()-1);
            }
        }
    }
}