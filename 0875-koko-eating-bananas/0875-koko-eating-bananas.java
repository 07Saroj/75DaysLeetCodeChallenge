class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile: piles){
            high=Math.max(high,pile);
        }

        int res=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canFinish(piles,mid,h)){

                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
    boolean canFinish(int[] piles,int k,int h){
        long totalHour=0;
        for(int pile:piles){
            totalHour +=(pile+k-1)/k;
        }

        return totalHour <= h;
    }
}