/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String token: tokens)
        {
            if(this.isOperator(token))
            {
                if(s.size()<2) throw new IllegalArgumentException();
                int num2=s.pop();
                int num1=s.pop();
                if(Objects.equals(token, "+")) s.push(num1+num2);
                else if(Objects.equals(token, "-")) s.push(num1-num2);
                else if(Objects.equals(token, "*")) s.push(num1*num2);
                else if(Objects.equals(token, "/")) s.push(num1/num2);
                else throw new RuntimeException("not support");
            }
            else
            {
                s.push(Integer.parseInt(token));
            }
        }
        if(s.size()!=1) throw new IllegalArgumentException();
        return s.pop();
    }

    private boolean isOperator(String s)
    {
        if(s==null) return false;
        if(Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/"))
            return true;
        return false;
    }
}
// @lc code=end

