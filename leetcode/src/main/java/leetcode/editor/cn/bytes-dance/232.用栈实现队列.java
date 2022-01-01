/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public MyQueue() {

    }
    
    public void push(int x) {
        // transger all ele from out to in before push pending item into in
        while(!out.isEmpty()){
            in.push(out.pop());
        }
        in.push(x);
        // gurantee the in is empty after push
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }
    
    public int pop() {
        if(out.isEmpty()) throw new RuntimeException("error");
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()) throw new RuntimeException("error");
        return out.peek();
    }
    
    public boolean empty() {
        return out.isEmpty();
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
// @lc code=end

