class Solution {
    class point{
        int x;
        int y;
        int dist;
        point(int x,int y, int d){
            this.x=x;
            this.y=y;
            dist=d;
        }
    }
    private static class PointsComparator implements Comparator<point>{
        public int compare(point p1,point p2){
            if(p1.dist<p2.dist){
                return 1;
            }else if(p2.dist<p1.dist){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<point> pq= new PriorityQueue(new PointsComparator());
        point[] p= new point[n];
        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dist=x*x+y*y;
            p[i]=new point(x,y,dist);
           
        }

        for(int i=0;i<n;i++){
            if(pq.size()==k){
                if(pq.peek().dist>p[i].dist){
                    pq.poll();
                    pq.add(p[i]);
                }
            }else{
                pq.add(p[i]);
            }    
        }

        int[][] res=new int[k][2];
        for(int i=0;i<k;i++){
            point a=pq.poll();
            res[i][0]=a.x;
            res[i][1]=a.y;
            
        }

        return res;    

    }
}