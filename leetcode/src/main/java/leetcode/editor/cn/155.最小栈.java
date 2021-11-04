/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    // 数据元素
    Stack<Integer> dataStack = new Stack<>();

    // 最小值
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }
    
    public void push(int val) {
        // 数据
        this.dataStack.push(val);
        // 最小值
        if(this.minStack.isEmpty()){
            this.minStack.push(val);
        }else{
            // 比较
            this.minStack.push(Math.min(this.minStack.peek(),val));
        }
    }
    
    public void pop() {
        if(!this.dataStack.isEmpty()){
            // 数据
            this.dataStack.pop();
            // 最小值
            this.minStack.pop();
        }
    }
    
    public int top() {
        if(!this.dataStack.isEmpty()){
            return this.dataStack.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!this.dataStack.isEmpty()){
            return this.minStack.peek();
        }
        return -1;
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

