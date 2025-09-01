class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        while(!queue1.isEmpty()){
            int ele = queue1.poll();
            queue2.offer(ele);
        }
        queue1.offer(x);
        while(!queue2.isEmpty()){
            int ele = queue2.poll();
            queue1.offer(ele);
        }
    }
    
    public int pop() {
        if(queue1.isEmpty()){
            System.out.println("stack underflow");
        }
        return queue1.poll();
        
    }
    
    public int top() {
        if(queue1.isEmpty()){
            System.out.println("stack underflow");
        }
        return queue1.peek();
        
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */