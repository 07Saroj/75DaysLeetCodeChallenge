class Solution {
    static int[] parent;
    public void union(int u,int v){
        int L1=find(u);
        int L2=find(v);
        if(L1!=L2){
            parent[L1]=L2;// OR parent[L2]=L1;
        }// If group leaders are same that means they are already in the same component
        
    }
    static int find(int a){
        if(parent[a]==a) return a;
        return find(parent[a]);
    }
    public int findCircleNum(int[][] isConnected) {
        //Disjoint set example
        int n=isConnected.length;
        parent= new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;
        parent[0]=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                // edge is from i+1 to j+1
                if(isConnected[i][j]==1){
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