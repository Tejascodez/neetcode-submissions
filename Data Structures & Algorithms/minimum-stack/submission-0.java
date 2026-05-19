class MinStack {

    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int k = Integer.MAX_VALUE;
        for(int n : stack){
            k = Math.min(k,n);
        }
        return k;
    }
}
