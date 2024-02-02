class Solution {
    List<Integer> sol = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i=1;i<=9;i++){
            solve(i,low, high);
        }
        Collections.sort(sol);
        return sol;
    }
    
    private void solve(long i, int low, int high){
        if(i>high){
            return;
        }else{
            if(i>=low){
                sol.add((int)i);
            }
            if(i%10<9){
                solve(i*10+(i%10)+1, low, high);
            }
        }
    }
}