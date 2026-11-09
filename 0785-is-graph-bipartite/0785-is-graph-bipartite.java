class Solution {
    static int[] parent;
    static boolean[] parity;
    static void union(int u,int v){
        int L1=find(u);
        int L2=find(v);
        if(find(u)!=find(v)){
            parent[L2]=L1;
        }
    }
    static int find(int a){
        if(parent[a]==a) return a;
        int Leader=find(parent[a]);
        parent[a]=Leader;
        return Leader;
    }
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        parent= new int[n];
        parity=new boolean[n];
        for(int i=0;i<n;i++) parent[i]=i;
        // In DSU we will not repeat the same edge
        for(int u=0;u<n;u++){
            for(int v: graph[u]){
                if(u<v){// To avoid edge repetation
                    if(find(u)!=find(v)){
                    union(u,v);
                    parity[v]=!parity[u];
                    }
                    if(find(u)==find(v) && parity[u]==parity[v]){
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}