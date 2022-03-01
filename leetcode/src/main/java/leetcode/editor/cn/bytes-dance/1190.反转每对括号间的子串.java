/*
 * @lc app=leetcode.cn id=1190 lang=java
 *
 * [1190] 反转每对括号间的子串
 */

// @lc code=start
class Solution {
    public String reverseParentheses(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) throw new IllegalArgumentException();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            char curCh = s.charAt(i);
            if(curCh=='('){
                stack.push(sb.toString());
                sb.setLength(0);
            }else if(curCh==')'){
                sb.reverse();
                sb.insert(0, stack.pop());
            }else sb.append(curCh);
        }
        return sb.toString();
    }
}
// @lc code=end

