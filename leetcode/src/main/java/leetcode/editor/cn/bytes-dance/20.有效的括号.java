/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int len=0; // length for str
        if(s==null || (len=s.length())==0) return false; // str is empty
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(); // pair, key is the right
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(int i=0; i<len; i++){ // iterator
            char curCh = s.charAt(i);
            if(map.containsKey(curCh)){
                // the right one
                if(stack.isEmpty()) return false;
                if(!Objects.equals(map.get(curCh), stack.peek())){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                // the left one
                stack.push(curCh);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

