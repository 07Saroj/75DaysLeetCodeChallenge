class Solution {
    
    public int findTheCity(int n, int[][] edges, int distThreshold) {
        int[][] adj=new int[n][n];
        for(int[] row : adj){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            adj[i][i]=0;
        }     

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj[u][v]=wt;
            adj[v][u]=wt;
        }
    

        //Floyd-Warshall algo
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(adj[i][k]!=Integer.MAX_VALUE && adj[k][j]!=Integer.MAX_VALUE){
                        adj[i][j]=Math.min(adj[i][j],adj[i][k]+adj[k][j]);
                    }
                }
            }
        }
        int idx=-1;
        int minCount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && adj[i][j]<=distThreshold){
                    count++;
                }
            }
            if(count<=minCount){
                idx=i;
                minCount=count;
            }
        }
        return idx; 

    }
}