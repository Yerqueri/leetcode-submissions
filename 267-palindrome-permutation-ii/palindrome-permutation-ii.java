class Solution {
    public List<String> generatePalindromes(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            arr[charToInt(c)]++;
        }
        String temp = "";
        for(int i=0;i<26;i++){
            if((arr[i]&1)==1){
                temp = temp+intToChar(i);
            }
        }
        if(temp.length()>1){
            return new ArrayList<>();
        }else{
            List<String> sol = new ArrayList<>();
            if(s.length()==1){
                arr[charToInt(s.charAt(0))]--;
            }
            solve(sol,arr,temp,temp.length(),s.length());
            return  sol;
        }
    }

    private void solve(List<String> sol, int[] arr, String temp, int curr, int length) {
        if(curr==length){
            sol.add(temp);
        }else{
            for(int i=0;i<26;i++){
                if(arr[i]>=2){
                    arr[i]-=2;
                    char c = intToChar(i);
                    solve(sol,arr,c+temp+c,curr+2,length);
                    arr[i]+=2;
                }
            }
        }
    }

    private char intToChar(int x){
        return (char)(x+'a');
    }

    private int charToInt(char c){
        return (int)c - (int)'a';
    }
}