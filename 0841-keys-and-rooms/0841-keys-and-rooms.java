class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] isVisited= new boolean[n];
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        isVisited[0]=true;

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

        for(int i=0;i<n;i++){
            if(!isVisited[i]) return false;
        }
        return true;

    }
}