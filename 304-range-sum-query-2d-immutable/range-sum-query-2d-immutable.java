class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        mat = matrix;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int a = i-1>=0?mat[i-1][j]:0;
                mat[i][j]=a+mat[i][j];
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int b = j-1>=0?mat[i][j-1]:0;
                mat[i][j]=b+mat[i][j];
            }
            //System.out.println(Arrays.toString(mat[i]));
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = col1-1>=0? mat[row2][col1-1]:0;
        int b = row1-1>=0?mat[row1-1][col2]:0;
        int c = row1-1>=0 && col1-1>=0 ? mat[row1-1][col1-1]:0;
        return mat[row2][col2]-a-b+c;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */