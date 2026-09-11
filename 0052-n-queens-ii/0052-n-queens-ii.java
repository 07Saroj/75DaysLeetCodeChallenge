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
        int n = board.length;

        // Check column above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check top-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check top-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}