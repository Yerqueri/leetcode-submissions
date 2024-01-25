class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        dp = new Integer[a.length][b.length];
        int sol = lcs(a,0,b,0);
        // for(int i=0;i<a.length;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return sol;
    }

    public int lcs(char[] a, int i, char [] b, int j) {
        if(i>=a.length || j>=b.length){
            return 0;
        }else if(dp[i][j]!=null){
            return dp[i][j];
        }else if(a[i]==b[j]){
            dp[i][j] = lcs(a,i+1,b,j+1)+1;
        }else{
            dp[i][j] = Math.max(lcs(a,i+1,b,j),lcs(a,i,b,j+1));
        }
        return dp[i][j];
    }
}