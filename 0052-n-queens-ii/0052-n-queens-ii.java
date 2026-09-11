class Solution {
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        int res=nQueen(board,0);
        return res;
    }
    private static int  nQueen(char[][] board, int row) {
        int n=board.length;
        if(row==n){
            return 1;
        }
        int count=0;
        for(int j=0;j< n;j++){// work and call
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                count+=nQueen(board,row+1);
                board[row][j]='.';// backtracking
            }
        }
        return count;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n= board.length;
        //check row
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q') return false;
        }
        //check col
        for (int i = 0; i < n; i++) {
            if(board[i][col]=='Q') return false;
        }
        //check northeast
        int i=row;
        int j=col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }
        //check southwest
        i=row;
        j=col;
        while(i<n && j<n){
            if(board[i][j]=='Q') return false;
            i++;
            j++;
        }
        //check southwest
        i=row;
        j=col;
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++;
            j--;
        }
        //check southwest
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        return true;
    }
}