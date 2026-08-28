class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());

        for(int ele: stones){
            pq.add(ele);
        }

        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y){
                pq.add(x-y);
            }
        }
        if(pq.size()==1){
            return pq.peek();
        }
        return 0;
    }
}