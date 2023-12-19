class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] dp = new int[m][n];
        int[] a = {-1,0,1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum = 0;
                int count =0;
                for(int k=0;k<a.length;k++){
                    for(int l=0;l<a.length;l++){
                        if(i+a[k]>=0 && i+a[k]<m && j+a[l]>=0 && j+a[l]<n){
                            sum+=img[i+a[k]][j+a[l]];
                            count++;
                        }
                    }
                }
                dp[i][j] = sum/count;
            }
        }
        return dp;
    }
}