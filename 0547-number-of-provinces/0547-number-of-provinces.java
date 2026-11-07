class Solution {
    static int[] parent;
    static int[] size;
    public void union(int u,int v){
        u =find(u);
        v=find(v);
        if(size[u]>size[v]){ // u should be parent of b
            parent[v]=u;
            size[u]+=size[v];
        }else{
            parent[u]=v;
            size[v]+=size[u];
        }
    }
    static int find(int a){
        if(parent[a]==a) return a;
        return find(parent[a]);
    }
    public int findCircleNum(int[][] isConnected) {
        //Disjoint set example
        int n=isConnected.length;
        parent= new int[n+1];
        size= new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i]=i;
            size[i]=1;
        }    
        parent[0]=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // edge is from i+1 to j+1
                if(i!=j && isConnected[i][j]==1){
                    union(i+1,j+1);//connecting group leaders of i+1 and j+1
                }
            }
        }

        int count=0;
        for(int i=1;i<=n;i++){
            if(parent[i]==i) count++;
        }
        return count;

    }
}