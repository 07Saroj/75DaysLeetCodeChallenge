class Solution {
    static class Pair{
        int dest,cost;
        Pair(int dest,int cost){
            this.dest=dest;
            this.cost=cost;
        }
    }
    static class Triplet{
        int dest,cost,stop;
        Triplet(int dest,int cost,int stop){
            this.dest=dest;
            this.cost=cost;
            this.stop=stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int c=flights[i][2];
            adj.get(u).add(new Pair(v,c));
        }
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        Queue<Triplet> pq= new LinkedList<>();
        pq.add(new Triplet(src,0,0));
        while(!pq.isEmpty()){
            Triplet top= pq.remove();
            int dest=top.dest;
            int s=top.stop;
            if(s==k+1) continue;
            
            for(Pair p : adj.get(dest)){
                int totalCost=top.cost+p.cost;
                if(totalCost<ans[p.dest]){
                    ans[p.dest]=totalCost;
                    pq.add(new Triplet(p.dest,totalCost,s+1));
                }
            }

        }

        return(ans[dst]==Integer.MAX_VALUE)?-1:ans[dst];
    }
}