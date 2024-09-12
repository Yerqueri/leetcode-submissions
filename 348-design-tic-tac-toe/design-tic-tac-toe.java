class TicTacToe {

    int[][] mat;
    boolean winnerDecalred;
    int winner = 0;
    int n = 0;

    public TicTacToe(int n) {
        mat = new int[n][n];
        winnerDecalred=false;
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        if(winnerDecalred){
            return winner;
        }else{
            mat[row][col] = player;
            int val = getWinner();
            if (val !=0){
                winner = val;
                winnerDecalred = true;
            }
            return val;
        }
    }

    private int getWinner(){
        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j =0;j<n;j++){
                set.add(mat[i][j]);
            }
            if(set.size()==1){
                return mat[i][0];
            }
        }
        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j =0;j<n;j++){
                set.add(mat[j][i]);
            }
            if(set.size()==1){
                return mat[0][i];
            }
        }
        int val1 =0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(mat[i][i]);
        }
        if(set.size()==1){
            val1 = mat[0][0];
        }

        int val2 =0;
        set.clear();
        for(int i=0;i<n;i++){
            set.add(mat[i][n-i-1]);
        }
        if(set.size()==1){
            val2 = mat[0][n-1];
        }
        if(val1!=0){
            return val1;
        }
        if(val2!=0){
            return val2;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */