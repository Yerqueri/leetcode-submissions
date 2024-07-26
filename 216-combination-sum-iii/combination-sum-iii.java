class Solution {
    List<List<Integer>> sol = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n<=0  || n>45){
            return sol;
        }
        solve(new ArrayList<>(),1,0,k,n);
        return sol;
    }

    private void solve(List<Integer> temp, int i, int sum ,int k, int n){
        if(i>10){
            return;
        }
        if(k==0){
            if(sum==n){
                sol.add(new ArrayList<>(temp));
            }
        }else{
            temp.add(i);
            solve(temp,i+1,sum+i,k-1,n);
            temp.remove(temp.size()-1);
            solve(temp,i+1,sum,k,n);
        }
    }
}