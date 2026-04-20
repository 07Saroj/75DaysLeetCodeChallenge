class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[]inDegree=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] row : prerequisites) {
            int course=row[0];
            int needed=row[1];

            graph.get(needed).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> res=new ArrayList<>();

        while(!q.isEmpty()){
            int completedCourse=q.poll();
            res.add(completedCourse);

            for(int EGC: graph.get(completedCourse)){
                inDegree[EGC]--;
                if(inDegree[EGC]==0){
                    q.add(EGC);
                }
            }
        }
        return numCourses==res.size();

    }

    
}