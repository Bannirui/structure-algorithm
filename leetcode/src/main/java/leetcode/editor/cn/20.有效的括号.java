/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character dest = map.get(s.charAt(i));
            if(dest==null){
                // 左括号
                stack.push(s.charAt(i));
            }else{
                // 右括号
                if(stack.isEmpty() || !Objects.equals(stack.peek(), dest)){
                    return false;
                }else{
                    // 消除栈中左括号
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

