class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n= prerequisites.length;
        List<List<Integer>> adj= new ArrayList<>();
        int[] inDegree= new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);// v -> u
            inDegree[u]++;
        }
        //Kahn's Algorithm
        Queue<Integer> q= new LinkedList<>();
        List<Integer> topo= new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) q.add(i);
            
        }
        while(!q.isEmpty()){
            int front=q.remove();
            topo.add(front);
            for(int ele : adj.get(front)){
                inDegree[ele]--;
                if(inDegree[ele]==0) q.add(ele);
            }
        }

        return topo.size()==numCourses;

    }
}