class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder()) ;
        for(char task: tasks){
            int idx=task-'A';
            freqs[idx]+=1;
        }

        for(int f : freqs){
            if(f>0)maxHeap.add(f);
        }

        int time=0;
        while(!maxHeap.isEmpty()){
            int cycle=n+1;
            int count=0;

            List<Integer> temp= new ArrayList<>();
            while(cycle >0 && !maxHeap.isEmpty()){
                temp.add(maxHeap.poll()-1);
                cycle--;
                count++;
            }

            for(int t: temp){
                if(t>0) maxHeap.add(t);
            }

            if(maxHeap.isEmpty()){
                time+=count;
            }else{
                time+=n+1;
            }
        }
        return time;


    }
}