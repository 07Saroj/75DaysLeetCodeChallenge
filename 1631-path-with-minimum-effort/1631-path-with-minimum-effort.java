class Solution {
    class triplet implements Comparable<triplet>{
        int row,col,dist;
        triplet(int row,int col,int dist){
            this.row = row;
            this.col= col;
            this.dist=dist;
        }

        public int compareTo(triplet t){
            if(this.dist==t.dist){
                if(this.row==t.row) return this.col-t.col;
                return this.row-t.row;
            } 
            return Integer.compare(this.dist,t.dist);
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n= heights[0].length;
        int[][] effortArr=new int[m][n];
        for(int[] row:effortArr){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effortArr[0][0]=0;

        PriorityQueue<triplet> pq= new PriorityQueue<>();
        pq.add(new triplet(0,0,0));

        while(!pq.isEmpty()){
            triplet top=pq.remove();
            int row= top.row;
            int col=top.col;
            int dist=top.dist;
            if(row==m-1 && col==n-1)return dist;
            if(dist>effortArr[row][col]) continue;
            if(row-1>=0) {
                int effort=Math.max(dist,Math.abs(heights[row][col]-heights[row-1][col]));
                if(effort<effortArr[row-1][col]){
                    effortArr[row-1][col]=effort;
                    pq.add(new triplet(row-1,col,effort));
                }
            } 
            if(row+1<m){
                int effort=Math.max(dist,Math.abs(heights[row][col]-heights[row+1][col]));
                if(effort<effortArr[row+1][col]){
                    effortArr[row+1][col]=effort;
                    pq.add(new triplet(row+1,col,effort));
                }
            } 
            if(col-1>=0) {
                int effort=Math.max(dist,Math.abs(heights[row][col]-heights[row][col-1]));
                if(effort<effortArr[row][col-1]){
                    effortArr[row][col-1]=effort;
                    pq.add(new triplet(row,col-1,effort));
                }
            }
            if(col+1<n) {
                int effort=Math.max(dist,Math.abs(heights[row][col]-heights[row][col+1]));
                if(effort<effortArr[row][col+1]){
                    effortArr[row][col+1]=effort;
                    pq.add(new triplet(row,col+1,effort));
                }    
            }
        }
        

        return 0;


    }
}