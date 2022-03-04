/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int n=i>=0?a.charAt(i)-'0':0;
            int m=j>=0?b.charAt(j)-'0':0;
            int sum=n+m+carry;
            sb.append(sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
}
// @lc code=end

