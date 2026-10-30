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
        int[][] dir={{-1,0},{0,-1},{+1,0},{0,+1}};

        while(!pq.isEmpty()){
            triplet top=pq.remove();
            int row= top.row;
            int col=top.col;
            int effort=top.dist;
            if(row==m-1 && col==n-1)return effort;
            if(effort>effortArr[row][col]) continue;
            for(int i=0;i<dir.length;i++){
                int nRow=row+dir[i][0];
                int nCol=col+dir[i][1];
                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n){
                    int nEffort=Math.max(effort,Math.abs(heights[row][col]-heights[nRow][nCol]));
                    if(nEffort<effortArr[nRow][nCol]){
                        effortArr[nRow][nCol]=nEffort;
                        pq.add(new triplet(nRow,nCol,nEffort));
                    }
                }

            }
        }
        

        return effortArr[m-1][n-1];


    }
}