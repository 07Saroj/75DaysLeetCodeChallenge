class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> ms;
    int minVal=Integer.MAX_VALUE;
    public MinStack() {
        s = new Stack <>();
        ms = new Stack <>();
    }
    
    public void push(int val) {
        if (ms.isEmpty() || val <= ms.peek()) {
            ms.push(val);
        }
        s.push(val);
    }
    
    public void pop() {
        if(!ms.isEmpty() && s.peek().equals(ms.peek())){
            ms.pop();
        }
        s.pop();
        
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        
        return ms.peek();
        
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */