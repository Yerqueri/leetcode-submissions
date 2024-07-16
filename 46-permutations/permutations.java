class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        sol = new ArrayList<>();
        permute(list,new ArrayList<>(),list.size());
        return sol;
    }

    private void permute(List<Integer> list, List<Integer> temp, int n){
        if(temp.size()==n){
            sol.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<list.size();i++){
                temp.add(list.get(i));
                List<Integer> l = new ArrayList<>(list);
                l.remove(i);
                permute(l,temp,n);
                temp.remove(temp.size()-1);
            }
        }
    }
}