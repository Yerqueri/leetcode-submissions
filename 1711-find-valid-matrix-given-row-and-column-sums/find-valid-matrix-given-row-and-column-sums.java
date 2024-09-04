class Solution {
    public int[][] restoreMatrix(int[] rowsum, int[] colsum) {
        int [][] sol = new int[rowsum.length][colsum.length];
        for(int i=0;i<rowsum.length;i++){
            for(int j=0;j<colsum.length;j++){
                sol[i][j] = Math.min(rowsum[i],colsum[j]);
                rowsum[i]-=sol[i][j];
                colsum[j]-=sol[i][j];
                //System.out.println(Arrays.toString(rowsum)+".."+Arrays.toString(colsum));
            }
        }
        return sol;
    }

    
}
// 3 0
// 1 7