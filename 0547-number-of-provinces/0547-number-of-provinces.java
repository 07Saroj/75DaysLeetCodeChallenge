class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] isVisited= new boolean[n];
        int p=0;
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                bfs(isConnected,isVisited,i);
                p++;
            }
        }
        return p;
    }
    static void bfs(int[][] isConnected,boolean[] isVisited,int i){
        int n=isConnected.length;
        Queue<Integer> q= new LinkedList<>();
        q.add(i);
        isVisited[i]=true;
        while(!q.isEmpty()){//while queue is not empty
            int front=q.remove();
            for(int j=0;j<n;j++){
                if(isConnected[front][j]==1 && !isVisited[j]){
                    q.add(j);
                    isVisited[j]=true;
                }
            }
        }

    }
}