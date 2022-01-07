/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {

    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> helpQ = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        // q->helpQ
        while(!q.isEmpty()){
            helpQ.offer(q.poll());
        }
        // x->q
        q.offer(x);
        // helpQ->q
        while(!helpQ.isEmpty()){
            q.offer(helpQ.poll());
        }
    }
    
    public int pop() {
        if(q.isEmpty()) throw new RuntimeException("err: empty");
        return q.poll();
    }
    
    public int top() {
        if(q.isEmpty()) throw new RuntimeException("err: empty");
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
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
// @lc code=end

