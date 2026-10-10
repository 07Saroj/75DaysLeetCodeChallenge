class Solution {
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        } 
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j] && grid[i][j]=='1'){
                    bfs(i,j,isVisited,grid);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int i,int j,boolean[][] isVisited,char[][] grid){
        int m=grid.length,n=grid[0].length;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j));
        isVisited[i][j]=true; 
        while(!q.isEmpty()){
            Pair front= q.remove();
            int row= front.x;
            int col=front.y;
            if(row-1 >= 0){//up
                if(grid[row-1][col]=='1' && !isVisited[row-1][col]){
                    q.add(new Pair(row-1,col));
                    isVisited[row-1][col]=true; 
                }
                
            }
            if(row+1<m){//down
                if(grid[row+1][col]=='1' && !isVisited[row+1][col]){
                    q.add(new Pair(row+1,col));
                    isVisited[row+1][col]=true; 
                }
                
            }
            if(col-1 >= 0){//left
                if(grid[row][col-1]=='1' && !isVisited[row][col-1]){
                    q.add(new Pair(row,col-1));
                    isVisited[row][col-1]=true; 
                }
            }

            if(col+1<n){//right
                if(grid[row][col+1]=='1' && !isVisited[row][col+1]){
                    q.add(new Pair(row,col+1));
                    isVisited[row][col+1]=true; 
                }
            }

        }
    }
}