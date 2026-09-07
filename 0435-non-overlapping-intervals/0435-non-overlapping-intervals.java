class Solution {
    static class interval{
        int start;
        int finish;
    }
    static class intervalComparator implements Comparator<interval>{
        public int compare(interval I1,interval I2){
            if(I1.start>I2.start){
                return 1;
            }else if(I1.start<I2.start){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        List<interval> Intervals= new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            interval I= new interval();
            I.start=intervals[i][0];
            I.finish=intervals[i][1];
            Intervals.add(I);
        }
        Intervals.sort(new intervalComparator());
        
        int res=0;
        int prevI_finish=Intervals.get(0).finish;
        for(int i=1;i<Intervals.size();i++){
            interval currI=Intervals.get(i);
            if(prevI_finish>currI.start){//overlap
                prevI_finish=Math.min(prevI_finish,currI.finish);
                res++;
            }else{
                prevI_finish=currI.finish;
            }   
            
        }

        return res;
    }
}