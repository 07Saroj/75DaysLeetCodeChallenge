class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        //1.Reverse the graph
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree= new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int ele : graph[i]){
                // in original graph, edge is i -> ele
                // in reverse graph, it will  ele -> i
                adj.get(ele).add(i);
                inDegree[i]++;// updating inDegree
            }
        }

        //kahn's algo
        Queue<Integer> q= new LinkedList<>();
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int front=q.remove();
            res.add(front);
            for(int ele : adj.get(front)){
                inDegree[ele]--;
                if(inDegree[ele]==0) q.add(ele);
            }
        }
        
        Collections.sort(res);// Sorting Acending order
        return res;
        
    }
}