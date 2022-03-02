/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if(s==null) throw new IllegalArgumentException();
        int ret=0;
        // index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='(') stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else ret=Math.max(ret, i-stack.peek());
            }
        }
        return ret;
    }
}
// @lc code=end

