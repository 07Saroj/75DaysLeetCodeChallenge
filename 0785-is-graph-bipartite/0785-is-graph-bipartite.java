class Solution {
    static boolean res;
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] isVisited=new int[n];
        Arrays.fill(isVisited,-1);
        res=true;
        for(int i=0;i<n;i++){
            if(i==0||isVisited[i]==-1){
                if(res==false) return res;
                bfs(i,graph,isVisited);
            }
        }
        return res;
    }

    private static void bfs(int i,int[][] graph,int[] isVisited){
        isVisited[i]=0;// 0-> blue, 1 -> red and initialisation
        Queue<Integer> q= new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front=q.remove();
            int color=isVisited[front];
            int[] arr=graph[front];
            for(int ele : arr){
                if(isVisited[ele]==color){
                    res=false;
                    return;
                }
                if(isVisited[ele]==-1){
                    q.add(ele);
                    isVisited[ele]=1-color;
                }
            }
        }
    }
}