class Solution {
    static class interval{
        int start;
        int finish;

        public String toString(){
            return start+"-"+finish;
        }    
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
        System.out.println(Intervals);
        int res=0;
        interval prevI=Intervals.get(0);
        for(int i=1;i<Intervals.size();i++){
            interval currI=Intervals.get(i);
            if(prevI.finish>currI.start){//overlap
                if(prevI.finish>currI.finish){//remove the longest finish time
                    res+=1;
                    prevI=currI;
                }else{
                    res+=1;
                }
            }else if(prevI.finish<=currI.start){
                prevI=currI;
            }
            
        }

        return res;
    }
}