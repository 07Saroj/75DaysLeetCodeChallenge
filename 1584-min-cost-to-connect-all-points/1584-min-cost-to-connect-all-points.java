class Solution {
    class Edge implements Comparable<Edge>{
        int node, parent, cost;
        Edge(int node,int parent,int cost){
            this.node=node;
            this.parent=parent;
            this.cost=cost;
        }
        public int compareTo(Edge e){
            if(this.cost==e.cost) return Integer.compare(this.parent,e.parent);
            return Integer.compare(this.cost,e.cost);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[] vis=new boolean[n];
        int count=0;
        int sum=0;
        PriorityQueue<Edge> pq= new PriorityQueue<>();
        pq.add(new Edge(0,-1,0));
        while(!pq.isEmpty()){
            Edge top=pq.remove();
            int node=top.node;
            int parent=top.parent;
            if(!vis[node]) {
                sum+=top.cost;
                count++;
            }    
            vis[node]=true;
            if(count==n) break;
            for(int i=0;i<n;i++){
                if(i==node || vis[i]==true) continue;
                int xi=points[i][0],yi=points[i][1],xj=points[node][0],yj=points[node][1];
                int cost=Math.abs(xi-xj)+Math.abs(yi-yj);
                pq.add(new Edge(i,node,cost));// node, parent,cost
            }    
        }
        return sum;
    }
}