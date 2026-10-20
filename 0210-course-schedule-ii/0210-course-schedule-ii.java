class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int n= pre.length;
        List<List<Integer>> adj= new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u= pre[i][0];
            int v= pre[i][1];
            adj.get(v).add(u);
            inDegree[u]++;
        }

        //kahn's Algo
        Queue<Integer> q = new LinkedList<>();
        int[] topo= new int[numCourses];
        int j=0;

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int front=q.remove();
            topo[j++]=front;
            for(int ele : adj.get(front)){
                inDegree[ele]--;
                if(inDegree[ele]==0) q.add(ele);
            }
        }
        if(j!=numCourses) return new int[0];
        return topo;
    }
}