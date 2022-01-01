/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    private Stack<Integer> valS = new Stack<>(); // stack for value
    private Stack<Integer> minS = new Stack<>(); // stack for min

    public MinStack() {

    }
    
    public void push(int val) {
        this.valS.push(val);
        int min = Math.min(val, this.minS.isEmpty()?Integer.MAX_VALUE:this.minS.peek());
        this.minS.push(min);
    }
    
    public void pop() {
        if(this.valS.isEmpty()) throw new RuntimeException("error");
        this.valS.pop();
        this.minS.pop();
    }
    
    public int top() {
        if(this.valS.isEmpty()) throw new RuntimeException("error");
        return this.valS.peek();
    }
    
    public int getMin() {
        if(this.valS.isEmpty()) throw new RuntimeException("error");
        return this.minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

