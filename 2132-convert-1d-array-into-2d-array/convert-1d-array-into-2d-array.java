class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length){
            return new int[][]{};
        }
        int i =0;
        int j =0;
        int k =0;
        int[][] mat = new int[m][n];
        while(j<m && i<original.length){
            while(k<n && i<original.length){
                mat[j][k]=original[i];
                k++;
                i++;
            }
            k=0;
            j++;
        }
        return mat;
    }
}