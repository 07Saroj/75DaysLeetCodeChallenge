class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] isVisited= new boolean[n];
        bfs(rooms,isVisited,0);
        
        for(boolean ele : isVisited){
            if(ele==false) return false;
        }
        return true;

    }

    private static void bfs(List<List<Integer>> rooms,boolean[] isVisited,int idx){
        Queue<Integer> q= new LinkedList<>();
        q.add(idx);
        isVisited[idx]=true;

        while(!q.isEmpty()){
            int currRoom=q.remove();
            List<Integer> keys=rooms.get(currRoom);
            for(int i=0;i<keys.size();i++){
                int k=keys.get(i);
                if(!isVisited[k]){
                    q.add(k);
                    isVisited[k]=true;
                }
            }
        }
    }
}