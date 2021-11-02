/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        // 括号对
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        // 左括号入栈 右括号消除
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char curChar = s.charAt(i);
            Character pairChar = map.get(curChar);
            if(pairChar==null){
                // 左括号
                stack.push(curChar);
            }else{
                // 右括号 弹出栈
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(Objects.equals(pairChar, stack.pop())){
                        // 消除
                    }else{
                        // 不成一对
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

