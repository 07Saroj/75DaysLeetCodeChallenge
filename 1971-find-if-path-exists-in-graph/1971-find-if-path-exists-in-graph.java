class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
        bfs(source, adj,isVisited);

        return isVisited[destination];
    }

    static void bfs(int i,List<List<Integer>> adj,boolean[] isVisited){
        Queue<Integer> q =new LinkedList<>();
        q.add(i);
        isVisited[i]=true;
        while(!q.isEmpty()){
            int front=q.remove();
            List<Integer> ls=adj.get(front);//eg 0: 1,2
            for(int ele : ls){
                if(!isVisited[ele]){
                    q.add(ele);
                    isVisited[ele]=true;
                }
            }
        }
    }
}