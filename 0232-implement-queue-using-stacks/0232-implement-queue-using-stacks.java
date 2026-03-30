class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input= new Stack<>();
        output= new Stack<>();
        
    }
    private void pushToOutput(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                int ele = input.pop();
                output.push(ele);
            }
        }
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        pushToOutput();
        return output.pop(); 
        
    }
    
    public int peek() {
        pushToOutput();

        return output.peek();
    }
    
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */