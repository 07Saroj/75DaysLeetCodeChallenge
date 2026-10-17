class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] isVisited= new boolean[n];
        dfs(source, adj,isVisited,destination);

        return isVisited[destination];
    }
    static void dfs(int i,List<List<Integer>> adj,boolean[] isVisited,int dest){
        isVisited[i]=true;
        if(i==dest) return ;
        List<Integer> ls= adj.get(i);
        for(int ele: ls){
            if(!isVisited[ele]){
                dfs(ele, adj,isVisited,dest);
            }
        }
    }

    
}