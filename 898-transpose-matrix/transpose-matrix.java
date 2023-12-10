class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] tp = new int[n][m];
        int i =0;
        for(int[] curr:matrix){
            for(int j=0;j<n;j++){
                tp[j][i] = curr[j];
            }
            i++;
        }
        return tp;
    }
}

// 1 2 3
// 4 5 6
// 1 4