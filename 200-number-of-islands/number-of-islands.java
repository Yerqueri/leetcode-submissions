class Solution {
    Set<String> visited;
    public int numIslands(char[][] grid) {
        visited = new HashSet<>();
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited.contains(i+"_"+j)){
                    count++;
                    runDfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void runDfs(char[][] grid, int i, int j){
        if(!visited.contains(i+"_"+j)){
            visited.add(i+"_"+j);
            if(i-1>=0 && grid[i-1][j]=='1'){
                runDfs(grid,i-1,j);
            }
            if(i+1<grid.length && grid[i+1][j]=='1'){
                runDfs(grid,i+1,j);
            }
            if(j-1>=0 && grid[i][j-1]=='1'){
                runDfs(grid,i,j-1);
            }
            if(j+1<grid[0].length && grid[i][j+1]=='1'){
                runDfs(grid,i,j+1);
            }
        }
    }
}