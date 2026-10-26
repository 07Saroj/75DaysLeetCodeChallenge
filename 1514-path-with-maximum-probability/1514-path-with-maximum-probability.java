class Solution {
    static class Pair {
        int node;
        double prob;
        Pair(int node,double prob){
            this.node=node;
            this.prob=prob;
        }

        // public int compareTo(Pair p){
        //     if( p.prob==this.prob) return this.node-p.node;
        //     return p.prob-this.prob;
        // }
    }
    private static class ProbComparator implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){
            if(p1.prob<p2.prob){
                return 1;
            }else if(p1.prob>p2.prob){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0],v=edges[i][1];
            double prob=succProb[i];
            adj.get(u).add(new Pair(v,prob));
            adj.get(v).add(new Pair(u,prob));
        }
        double[] probArr= new double[n];
        Arrays.fill(probArr,0);
        probArr[start_node]=1;
        PriorityQueue<Pair> pq= new PriorityQueue<>(new ProbComparator());
        pq.add(new Pair(start_node,1));
        while(!pq.isEmpty()){
            Pair top=pq.remove();
            int node=top.node;
            double prob=top.prob;
            for(Pair p : adj.get(node)){
                double total_prob=prob*p.prob;
                if(total_prob > probArr[p.node]){
                    probArr[p.node]=total_prob;
                    pq.add(new Pair(p.node,total_prob));
                }
            }
        } 
       

        return (probArr[end_node]==-1)? 0 : probArr[end_node];
    }
}