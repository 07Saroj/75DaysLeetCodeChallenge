class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
            
        }
        return minHeap.peek();

        // PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        // for(int num: nums){
        //     maxHeap.add(num);
        // }

        // while(k-1>0){
        //     maxHeap.poll();
        //     k--;
        // }

        // return maxHeap.peek();


    }
}