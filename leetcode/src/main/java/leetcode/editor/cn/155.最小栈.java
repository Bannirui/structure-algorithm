/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    Stack<Integer> data = new Stack<>();

    Stack<Integer> min = new Stack<>();

    public MinStack() {

    }
    
    public void push(int val) {
        this.data.push(val);
        if(this.min.isEmpty()){
            this.min.push(val);
        }else{
            this.min.push(Math.min(this.min.peek(),val));
        }
    }
    
    public void pop() {
        if(!this.data.isEmpty()){
            this.data.pop();
            this.min.pop();
        }
    }
    
    public int top() {
        if(!this.data.isEmpty()){
            return this.data.peek();
        }else{
            return -1;
        }
    }
    
    public int getMin() {
        return this.min.isEmpty()?-1:this.min.peek();
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

