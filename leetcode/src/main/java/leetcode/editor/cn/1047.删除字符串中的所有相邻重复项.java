/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curCh = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(curCh);
            }else{
                if(stack.peek()==curCh){
                    // remove
                    stack.pop();
                }else{
                    stack.push(curCh);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

