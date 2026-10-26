class Solution {
    static class Pair{
        int node, cost;
        Pair(int node,int c){
            this.node=node;
            this.cost=c;
        }

    }
    private static class CostComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            if(p1.cost>p2.cost){
                return 1;
            }else if(p1.cost<p2.cost){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList());
        for(int i=0;i<times.length;i++){
            int u=times[i][0],v=times[i][1],c=times[i][2];
            Pair p=new Pair(v,c);
            adj.get(u).add(p);
        }
        int[] CostArr = new int[n+1];
        Arrays.fill(CostArr,Integer.MAX_VALUE);
        CostArr[k]=0;
        CostArr[0]=-1;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CostComparator());
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair top=pq.remove();
            if(top.cost>CostArr[top.node]) continue;//optional
            for(Pair p : adj.get(top.node)){
                int totalCost=top.cost+p.cost;
                if(totalCost<CostArr[p.node]){
                    CostArr[p.node]=totalCost;
                    pq.add(new Pair(p.node,totalCost));
                }
            }
        }

        int max=0;
        for(int cost : CostArr){
            if(cost==Integer.MAX_VALUE) return -1;
            max=Math.max(max,cost);
        }
        return max;
    }

}