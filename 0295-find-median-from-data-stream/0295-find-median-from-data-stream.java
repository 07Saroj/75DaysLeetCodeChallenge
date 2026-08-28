class MedianFinder {
    PriorityQueue<Integer> leftPq;
    PriorityQueue<Integer> rightPq;
    public MedianFinder() {
        leftPq = new PriorityQueue<>(Comparator.reverseOrder());
        rightPq= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftPq.isEmpty() || num<leftPq.peek()){
            leftPq.add(num);
        }else{
            rightPq.add(num);
        }

        if(leftPq.size()>rightPq.size()+1){
            rightPq.add(leftPq.poll());
        }else if(rightPq.size()>leftPq.size()){
            leftPq.add(rightPq.poll());
        }
    }
    
    public double findMedian() {
        if(leftPq.size()>rightPq.size()){
            return leftPq.peek();
        }else{
            return (leftPq.peek()+rightPq.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */