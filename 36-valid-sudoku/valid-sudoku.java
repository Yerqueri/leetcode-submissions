class Solution {
        public boolean isValidSudoku(char[][] board) {
            return validRows(board) && validColumns(board) && validBoxes(board);
        }
        
        private boolean validBoxes(char[][] board){
            boolean flag= true;
            for(int i=0;i<=6;i+=3){
                for(int j=0;j<=6;j+=3){
                    flag &= isValidBox(board,i,j);
                    if(!flag){
                        return flag;
                    }
                }
            }
            return flag;
        }

        private boolean isValidBox(char[][] board, int i, int j) {
            Set<Character> s = new HashSet<>();
            for(int x =i;x<i+3;x++){
                for(int y=j;y<j+3;y++){
                    if(board[x][y] != '.' && !s.add(board[x][y])){
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean validColumns(char[][] board) {
            boolean flag = true;
            for(int i=0;i<board.length;i++){
                flag&=isValidColumn(board, i);
                if(!flag){
                    return flag;
                }
            }
            return flag;
        }

        private boolean isValidColumn(char[][] board, int i) {
            Set<Character> s = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[j][i] != '.' && !s.add(board[j][i])){
                    return false;
                }
            }
            return true;
        }

        private boolean validRows(char[][] board){
            boolean flag = true;
            for(int i=0;i<9;i++){
                flag&=isValidRow(board, i);
                if(!flag){
                    return flag;
                }
            }
            return flag;
        }

        private boolean isValidRow(char[][] board, int i) {
            Set<Character> s = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] != '.' && !s.add(board[i][j])){
                    return false;
                }
            }
            return true;
        }
    }