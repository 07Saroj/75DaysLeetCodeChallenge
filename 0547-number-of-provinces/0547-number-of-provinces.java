class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] isVisited= new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                dfs(isConnected,isVisited,i);
                count++;
            }
        }
        return count;
    }
    static void dfs(int[][] isConnected,boolean[] isVisited,int i){
        int n=isConnected.length;
        isVisited[i]=true;
        
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && !isVisited[j]){
                dfs(isConnected,isVisited,j);
            }
        }
        

    }
}