import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    // 常规栈存储数据
    Stack<Integer> dataStack = new Stack<>();
    // 最小数
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        // 数据栈
        this.dataStack.push(val);
        // 最小栈
        if (this.minStack.isEmpty() || val <= this.minStack.peek()) {
            this.minStack.push(val);
        } else {
            this.minStack.push(this.minStack.peek());
        }
    }

    public void pop() {
        // 数据栈
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException();
        }
        this.dataStack.pop();
        // 最小栈
        this.minStack.pop();
    }

    public int top() {
        // 数据栈
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException();
        }
        return this.dataStack.peek();
    }

    public int getMin() {
        // 最小栈
        if (this.minStack.isEmpty()) {
            throw new RuntimeException();
        }
        return this.minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
// @lc code=end
