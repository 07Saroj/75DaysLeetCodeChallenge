class Solution {
    static int check=0;
    static void solve(char[][] board,int row,int col){
        if(row==9){
            check=1;//triggers when the whole board is correctly filled.
            return;
        }
        else if(board[row][col]!='.'){ //call next
            if(col!=8)solve(board,row,col+1);
            else solve(board,row+1,0);
        }else{//empty place
            for(char ch='1';ch<='9';ch++){
                if(isValid(board,row,col,ch)){
                    board[row][col]=ch;
                    if(col!=8)solve(board,row,col+1);//call next
                    else solve(board,row+1,0);
                    if(check==1) return;// avoid backtracking after reaching the end
                    board[row][col]='.';//backtracking
                }
            }
        }
    }
    private static boolean isValid(char[][] board,int row,int col,char ch){
        //check row
        for(int j=0;j<9;j++){
            if(board[row][j]==ch) return false;
        }
        //check col
        for(int i=0;i<9;i++){
            if(board[i][col]==ch) return false;
        }
        //check 3x3 grid
        int sRow=row/3*3;
        int sCol=col/3*3;
        for(int i=sRow;i<sRow+3;i++){
            for(int j=sCol;j<sCol+3;j++){
                if(board[i][j]==ch) return false;
            }
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
        // char[][] grid= new char[9][9];
        solve(board,0,0);
        check=0;
        // for(int i=0;i<9;i++){
        //         for(int j=0;j<9;j++){
        //             board[i][j]=grid[i][j];
        //         }
        //     }
        
    }
}