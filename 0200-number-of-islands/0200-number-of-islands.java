class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j] && grid[i][j]=='1'){
                    dfs(i,j,isVisited,grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i,int j,boolean[][] isVisited,char[][] grid){
        int m= grid.length;
        int n=grid[0].length;
        isVisited[i][j]= true;
        if(i-1>=0 && grid[i-1][j]=='1' && !isVisited[i-1][j]) dfs(i-1,j,isVisited,grid);//UP
        if(i+1<m && grid[i+1][j]=='1' && !isVisited[i+1][j]) dfs(i+1,j,isVisited,grid);//DOWN
        if(j-1>=0 && grid[i][j-1]=='1' && !isVisited[i][j-1]) dfs(i,j-1,isVisited,grid);//LEFT
        if(j+1<n && grid[i][j+1]=='1' && !isVisited[i][j+1]) dfs(i,j+1,isVisited,grid);//Right
    }
}