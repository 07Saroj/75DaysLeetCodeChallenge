class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] resArr=new int[numCourses];
        for(int i=0;i<res.size();i++){
            resArr[i]=res.get(i);
        }
        if(numCourses==res.size()){
            return resArr;
        }
        return new int[0];
    }
}