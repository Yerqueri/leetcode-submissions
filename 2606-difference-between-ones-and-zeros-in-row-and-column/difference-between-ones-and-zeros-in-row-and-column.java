class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] row1 = new int[grid[0].length];
        int[] row0 = new int[grid[0].length];
        int[] col1 = new int[grid.length];
        int[] col0 = new int[grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    row0[j]++;
                    col0[i]++;
                }else{
                    row1[j]++;
                    col1[i]++;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j] = row1[j] + col1[i] - row0[j] -col0[i];
            }
        }
        return grid;
    }
}