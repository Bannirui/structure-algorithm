/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {

    Queue<Integer> in = new LinkedList<>();
    Queue<Integer> out = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        // out队列数据 in空队列
        while(!out.isEmpty()){
            // out->in
            in.offer(out.poll());
        }
        // 数据现在全在in中 lifo
        out.offer(x);
        while(!in.isEmpty()){
            out.offer(in.poll());
        }
    }
    
    public int pop() {
        return out.isEmpty()?-1:out.poll();

    }
    
    public int top() {
        return out.isEmpty()?-1:out.peek();
    }
    
    public boolean empty() {
        return out.isEmpty();
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

