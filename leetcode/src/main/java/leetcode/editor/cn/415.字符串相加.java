/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry=0;
        int r1=num1.length()-1;
        int r2=num2.length()-1;
        while(r1>=0 || r2>=0){
            int n1 = r1>=0?num1.charAt(r1)-'0':0;
            int n2 = r2>=0?num2.charAt(r2)-'0':0;
            int sum=n1+n2+carry;
            carry=sum/10;
            sb.append(sum%10);
            r1--;
            r2--;
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

