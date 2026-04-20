class Solution {
    static List<List<Integer>> graph=new ArrayList<>();
    static boolean[] visited;
    int[] cmCount;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        cmCount = new int[n];
        graph = new ArrayList<>();
        
        // Correct initialization
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        dfs(0);
        long fuelCon=0;
        for(int state=1;state<roads.length+1;state++){
            fuelCon+=Math.ceil((double)cmCount[state]/seats);

        }
        return fuelCon;
    }

    void dfs(int cmHouse){
        cmCount[cmHouse]=1;
        for(int neighCmHouse: graph.get(cmHouse)){
            if(cmCount[neighCmHouse]==0){
                dfs(neighCmHouse);
                cmCount[cmHouse]+=cmCount[neighCmHouse];
            }
        }
    }
}