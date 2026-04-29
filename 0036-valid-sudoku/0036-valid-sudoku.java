class Solution {
    public boolean isValidSudoku(char[][] board) {
        
       if(!checkRows(board) || !checkCols(board)) return false;

       for(int i=0;i<9;i+=3){
        for(int j=0;j<9;j+=3){
            if(!checkBox(board,i,j))return false;
        }
       }
       return true;

    }

    boolean checkRows(char[][] board){
        
        for(int i=0;i<9;i++){
            int[] count=new int[10];
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){ 
                    continue;
                }else{
                    int idx=board[i][j]-'0';
                    if(count[idx]<1){
                        count[idx]++;
                    }else{
                        return false;
                    }
                }
                
                
            }
        }
        return true;
    }

    boolean checkCols(char[][] board){
        
        for(int j=0;j<9;j++){
            int[] count=new int[10];
            for(int i=0;i<9;i++){
                if(board[i][j]=='.'){ 
                    continue;
                }else{
                    int idx=board[i][j]-'0';
                    if(count[idx]<1){
                        count[idx]++;
                    }else{
                        return false;
                    }
                }
                
                
            }
        }
        return true;
    }

    boolean checkBox(char[][] board,int rstart,int cstart){
        
        
      
        int[] count =new int[10];
        for(int i=rstart;i<rstart+3;i++){
            for(int j=cstart;j<cstart+3;j++){
                
                char val=board[i][j];
                if(val!='.'){
                    int idx=val-'0';
                    if(count[idx]<1){
                        count[idx]++;
                    }else{
                        return false;
                    }
                }
                    
            }
        }

        return true ;
        
    }
}