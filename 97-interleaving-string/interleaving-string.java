class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return isPossible(s1,s2,s3,0,0,0);
    }

    public boolean isPossible(String s1, String s2, String s3, int a, int b, int c) {
        if (dp[a][b] != null) {
            return dp[a][b];
        }
        if (a == s1.length() && b == s2.length() && c == s3.length()) {
            dp[a][b] = true;
        } else if (c < s3.length() && a < s1.length() && s1.charAt(a) == s3.charAt(c) && b < s2.length()
                && s2.charAt(b) == s3.charAt(c)) {
            dp[a][b] = isPossible(s1, s2, s3, a + 1, b, c + 1) || isPossible(s1, s2, s3, a, b + 1, c + 1);
        } else if (c < s3.length() && a < s1.length() && s1.charAt(a) == s3.charAt(c)) {
            dp[a][b] = isPossible(s1, s2, s3, a + 1, b, c + 1);
        } else if (c < s3.length() && b < s2.length() && s2.charAt(b) == s3.charAt(c)) {
            dp[a][b] = isPossible(s1, s2, s3, a, b + 1, c + 1);
        } else {
            dp[a][b] = false;
        }
        return dp[a][b];
    }
}