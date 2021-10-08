/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        // base case
        int len = 0;
        if (s == null || (len = s.length()) == 0) {
            return false;
        }
        // 成对
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            Character pair = map.get(curChar);
            if (pair == null) {
                // ( { [
                stack.push(curChar);
            } else {
                // ) } ]
                if (stack.isEmpty() || !Objects.equals(stack.peek(), pair)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
