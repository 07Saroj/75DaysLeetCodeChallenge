class Solution {
    static class Edge implements Comparable<Edge>{
        int u,v,cost;
        Edge(int u,int v,int cost){
            this.u=u;
            this.v=v;
            this.cost=cost;
        }

        public int compareTo(Edge e){
            if(this.cost==e.cost) return Integer.compare(this.u,e.u);
            return Integer.compare(this.cost,e.cost);
        }
    }
    //DSU
    static int[] parent;
    static void union(int u,int v){
        int L1=find(u);
        int L2=find(v);
        if(L1!=L2) parent[L2]=L1;
    }
    static int find(int a){
        if(parent[a]==a) return a;
        int Leader=find(parent[a]);
        parent[a]=Leader;
        return Leader;
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;

        // PriorityQueue<Edge> pq= new PriorityQueue<>();
        List<Edge> ls=new ArrayList<>();
        //Form edge
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int xi=points[i][0],yi=points[i][1];
                int xj=points[j][0],yj=points[j][1];
                int cost=Math.abs(xi-xj)+Math.abs(yi-yj);
                ls.add(new Edge(i,j,cost));//list O(1) ,pq->O(logn)
            }
        }
        Collections.sort(ls);
        int ans=0;
        for(int i=0;i<ls.size();i++){
            Edge top=ls.get(i);
            int u=top.u;
            int v=top.v;
            int cost=top.cost;
            if(find(u)!=find(v)){
                ans+=cost;
                union(u,v);
            }
        }
        // while(!pq.isEmpty()){
        //     Edge top=pq.;
        //     int u=top.u;
        //     int v=top.v;
        //     int cost=top.cost;
        //     if(find(u)!=find(v)){
        //         ans+=cost;
        //         union(u,v);
        //     }
        // }
        return ans;
    }
}