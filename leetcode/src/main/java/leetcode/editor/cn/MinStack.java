package leetcode.editor.cn;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
// 👍 834 👎 0

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MyMinStack minStack = new MyMinStack();
        minStack.push(1);
        minStack.pop();
        int top = minStack.top();
        int min = minStack.getMin();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class MyMinStack {
        /**
         * 栈特点 filo
         * 每次pop top getMin方法调用前先校验非空栈
         * O(n)查询最小值 每次push pop操作都要对最小值进行判断并更新 也就是对栈中每个元素维护一个最小值 同步存储在栈中 跟元素同步进行入栈出栈
         *     维护一个辅助栈
         */

        private Stack<Integer> save;

        private Stack<Integer> min;

        /** initialize your data structure here. */
        public MyMinStack() {
            // 构造方法初始化栈
            save = new Stack<Integer>();
            min = new Stack<Integer>();
            // 首次初始化完 栈里面元素为空 那么也就没有对应的最小值 辅助栈也设置为空
        }

        public void push(int x) {
            save.push(x);
            // 更新最小值
            if (min.isEmpty() || x <= min.peek()) {
                min.push(x);
            }
        }

        public void pop() {
            if (save.pop().equals(min.peek())) {
                min.pop();
            }
        }

        public int top() {
            return save.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
