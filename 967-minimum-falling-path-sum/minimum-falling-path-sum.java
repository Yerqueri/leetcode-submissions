class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                //System.out.println(i+" "+j);
                int a = j-1>=0? matrix[i+1][j-1]:10001;
                int b = j+1<n? matrix[i+1][j+1]:10001;
                int c = matrix[i+1][j];
                matrix[i][j]+=Math.min(a,Math.min(b,c));
            }
        }
        // for(int i=0;i<m;i++){
        //     System.out.println(Arrays.toString(matrix[i]));
        // }
        int sol = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sol = Math.min(sol,matrix[0][i]);
        }
        return sol;
    }
}