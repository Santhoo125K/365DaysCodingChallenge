class MyStack {

    /** Initialize your data structure here. */
  
  Queue<Integer> q1;
  Queue<Integer> q2;
  int res;
  
    public MyStack() {
      q1=new LinkedList<>();//queue1
      q2=new LinkedList<>();//queue2
        res=0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
      q2.add(x);
      
      while(!q1.isEmpty())
      {
        q2.add(q1.peek());
        q1.remove();
    }
      
      Queue<Integer> Q=q2;
      q2=q1;
      q1=Q;
      
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      if(empty()==false)
      res=top();
      q1.remove();
      return res;
      
        
    }
    
    /** Get the top element. */
    public int top() {
     
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
      return q1.isEmpty();
        
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