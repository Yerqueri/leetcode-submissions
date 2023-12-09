class Solution {
    public int countSquares(int[][] matrix) {
        int count =0;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==1 && matrix[i-1][j]>0 && matrix[i][j-1]>0 && matrix[i-1][j-1]>0){
                    matrix[i][j] +=Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j],matrix[i][j-1]));
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                count+=matrix[i][j];
            }
        }
        return count;
    }
}
// 1 0 1
// 1 1 0
// 1 2 0