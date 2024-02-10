class Solution {
    Boolean[][] dp;


    public int countSubstrings(String s) {
        dp = new Boolean[s.length()][s.length()];
        int count =0;
        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>=i;j--){
                if(isPalindrome(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int i, int j){
        if(dp[i][j]!=null){
            return dp[i][j];
        }else if(i==j){
            dp[i][j]=true;
        }else if(j==i+1){
            dp[i][j]=s.charAt(i)==s.charAt(j);
        }else if(i<j && s.charAt(i)==s.charAt(j)){
            dp[i][j]= isPalindrome(s, i+1,j-1);
        }else{
            dp[i][j]=false;
        }
        return dp[i][j];
    }
}