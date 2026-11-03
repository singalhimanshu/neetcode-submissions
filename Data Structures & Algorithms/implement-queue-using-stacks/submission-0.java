class MyQueue {
    Stack<Integer> inStk = new Stack<>();
    Stack<Integer> outStk = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        inStk.push(x);
    }
    
    public int pop() {
        if (!outStk.isEmpty()) {
            return outStk.pop();
        }
        while (!inStk.isEmpty()) {
            outStk.push(inStk.pop());
        }
        return outStk.pop();
    }
    
    public int peek() {
        if (!outStk.isEmpty()) {
            return outStk.peek();
        }
        while (!inStk.isEmpty()) {
            outStk.push(inStk.pop());
        }
        return outStk.peek();
    }
    
    public boolean empty() {
        return inStk.isEmpty() && outStk.isEmpty();
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