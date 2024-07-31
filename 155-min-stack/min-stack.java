class MinStack {

    List<Integer> min;
    Stack<Integer> stack;
    int size;

    public MinStack() {
        min = new ArrayList<>();
        stack = new Stack<>();
        size =0;
    }
    
    public void push(int val) {
        if(size==0){
            min.add(val);
            stack.push(val);
        }else{
            min.add(Math.min(min.get(size-1),val));
            stack.push(val);
        }
        size++;
        //debug();
    }
    
    public void pop() {
        if(size!=0){
            min.remove(size-1);
            stack.pop();
            size--;
        }
        //debug();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        //debug();
        return min.get(size-1);
    }
    // private void debug(){
    //     System.out.println(stack);
    //     System.out.println(min);
    //     System.out.println(size);
    //     System.out.println();
    // }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */