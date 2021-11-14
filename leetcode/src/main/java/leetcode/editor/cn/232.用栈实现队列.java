/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public MyQueue() {

    }
    
    public void push(int x) {
        while(!out.isEmpty()){
            in.push(out.pop());
        }
        in.push(x);
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }
    
    public int pop() {
        if(out.isEmpty()){
            return -1;
        }
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            return -1;
        }
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

