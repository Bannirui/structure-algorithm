/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        int len=0;
        if(num==null || (len=num.length())==0 || k<0) throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<len; i++){
            char ch = num.charAt(i);
            while(!stack.isEmpty() && k>0 && ch<stack.peek()){
                k--;
                stack.pop();
            }
            stack.push(ch);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        Stack<Character> reversedStack = new Stack<>();
        while(!stack.isEmpty()) reversedStack.push(stack.pop());

        StringBuilder sb = new StringBuilder();
        boolean leadingZero=true;
        while(!reversedStack.isEmpty()){
            char ch = reversedStack.pop();
            if(leadingZero && ch=='0') continue;
            leadingZero=false;
            sb.append(ch);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
// @lc code=end

