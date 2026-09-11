class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res= new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        nQueen(board,0,res);
        return res;
    }

    private static void nQueen(char[][] board, int row,List<List<String>> res) {
        int n=board.length;
        if(row==n){
            List<String> ls= new ArrayList<>();
            for(int i=0;i<n;i++){
                String r="";
                for(int j=0;j<n;j++){
                    r+=board[i][j];
                }
                ls.add(r);
            }
            res.add(ls);
            return;
        }
        for(int j=0;j< n;j++){// work and call
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nQueen(board,row+1,res);
                board[row][j]='.';// backtracking
            }
        }
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