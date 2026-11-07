class Solution {
    static int[] parent;
    static int[] extraEdge;
    public void union(int u,int v){
        int L1=find(u);
        int L2=find(v);
        if(L1==L2){//same parent -> extra edge
            extraEdge[0]=u;
            extraEdge[1]=v;
        }else{
            parent[L2]=L1;
        }
    }
    public int find(int a){
        if(parent[a]==a) return a;
        int leader=find(parent[a]);
        parent[a]=leader;
        return leader;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent= new int[n+1];
        extraEdge= new int[2];
        for(int i=1;i<=n;i++) parent[i]=i;
        parent[0]=-1;
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(find(u)==find(v)){
                extraEdge[0]=u;
                extraEdge[1]=v;
            }
            union(u,v);
        }
        return extraEdge;
    }
}