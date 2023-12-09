class Solution {
    Set<String> s = new HashSet<>();
    public List<String> generateParenthesis(int n) {
        generate("",0,0,n);
        return new ArrayList<>(s);
    }
    
    private void generate(String curr, int open, int close, int n){
        if(curr.length() == 2*n){
            s.add(curr);
        }else{
            if(open>close){
                generate(curr+")",open,close+1,n);
            }
            if(open<n){
                generate(curr+"(",open+1,close,n);
            }
        }
    }
}