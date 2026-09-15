class Solution {
    private static boolean isValid(char[][] board,int row,int col,char num){
        //check row
        for(int j=0;j<9;j++){
            if(board[row][j]==num){
                return false;
            }
        }
        //check cols
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        //check 3x3 grid
        //To get the starting point of the grid :
        // we 1st divide the row/3 then multiply by 3
        //eg.:(4,3)->4/3=1,3/3=1 .1x3=3,1x3=3.So startig point for the coordinate (4,3) is (3,3).
        int sRow=(row/3)*3;
        int sCol=(col/3)*3;
        for(int i=sRow;i<sRow+3;i++){
            for(int j=sCol;j<sCol+3;j++){
                if(board[i][j]==num)return false;
            }
        }
        return true;

    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num=board[i][j];
                if(num=='.')continue;
                board[i][j]='.';
                if(isValid(board,i,j,num)==false) return false;
                board[i][j]=num;
            }
        }
        return true;
    }
}