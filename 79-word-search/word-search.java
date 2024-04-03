class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                //System.out.println(i+" "+j);
                if(dfs(word,visited,board,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String word, boolean[][] visited, char[][] board, int i, int j, int k){
        if(visited[i][j] || board[i][j]!=word.charAt(k)){
            return false;
        }else if(k==word.length()-1){
            // System.out.println(i+" "+j+" "+k);
            // for(int l=0;l<visited.length;l++){
            //     System.out.println(Arrays.toString(visited[l]));
            // }
            return word.charAt(k)==board[i][j];
        }else{
            int[] x = new int[]{0,-1,0,1};
            int[] y = new int[]{1,0,-1,0};
            boolean flag = false;
            for(int p=0;p<x.length;p++){
                int x1 = i+x[p];
                int y1 = j+y[p];
                if(x1>=0 
                    && x1<board.length
                    && y1>=0 
                    && y1<board[0].length
                    ){
                    visited[i][j] = true;
                    flag = flag || dfs(word,visited,board,x1,y1,k+1);
                    visited[i][j] = false;
                }
            }
            return flag;
        }
    }
}

// 1,2
// 0,1
// 1,0
// 2,1