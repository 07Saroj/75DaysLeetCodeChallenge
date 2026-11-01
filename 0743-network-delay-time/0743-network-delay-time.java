class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[k]=0;
        cost[0]=-1;
        
        for(int i=0;i<n-1;i++){//n-1 times
            for(int[] row : times){
                int u=row[0];
                int v=row[1];
                int wt=row[2];
                if(cost[u]!=Integer.MAX_VALUE && cost[u]+wt<cost[v]){
                    cost[v]=cost[u]+wt;
                }
            }
        }

        
        int max=0;
        for(int ele: cost){
            if(ele==Integer.MAX_VALUE) return -1;
            max=Math.max(max,ele);
        }
        return max;
    }
}