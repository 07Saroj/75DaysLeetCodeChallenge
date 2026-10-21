class Solution {
    static boolean ans;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ans=true;
        int n= prerequisites.length;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);// v -> u
            
        }
        boolean[] isVisited= new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!isVisited[i]){
                dfs(i,adj,isVisited,path);
            }
        }
        return ans;
    }

    private static void dfs(int i,List<List<Integer>> adj,boolean[] isVisited,boolean[] path){
        isVisited[i]=true;
        path[i]=true;
        for(int ele : adj.get(i)){
            if(path[ele]){
                ans=false;
                return;
            }
            if(!isVisited[ele])dfs(ele,adj,isVisited,path);
            
        }
        path[i]=false;
    }
}