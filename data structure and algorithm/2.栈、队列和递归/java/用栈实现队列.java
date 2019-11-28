class MyQueue {

    private Stack<Integer> stack1;//入队操作，入该栈
    private Stack<Integer> stack2;//出队操作，出该栈
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //stack1移动到stack2
        while(!this.stack1.isEmpty()){
            this.stack2.push(this.stack1.pop());
        }
        int result = this.stack2.pop();
        //stack2移回stack1
        while(!this.stack2.isEmpty()){
            this.stack1.push(this.stack2.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
         //stack1移动到stack2
        while(!this.stack1.isEmpty()){
            this.stack2.push(this.stack1.pop());
        }
        int result = this.stack2.peek();
        //stack2移回stack1
        while(!this.stack2.isEmpty()){
            this.stack1.push(this.stack2.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack1.isEmpty();
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