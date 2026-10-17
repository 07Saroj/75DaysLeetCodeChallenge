class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] isVisited= new boolean[n];
        dfs(rooms,isVisited,0);
        for(boolean ele : isVisited){
            if(ele==false) return false;
        }
        return true;
    }
    private static void dfs(List<List<Integer>> rooms,boolean[] isVisited,int idx){
        isVisited[idx]=true;
        List<Integer> keys=rooms.get(idx);
        for(int k : keys){
            if(!isVisited[k]){
                dfs(rooms,isVisited,k);
            }
        }
    }

    
}