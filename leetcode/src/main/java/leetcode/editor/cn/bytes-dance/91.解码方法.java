/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if(s==null) throw new IllegalArgumentException();
        int len=s.length();
        int[] dp = new int[len+1];
        dp[0]=1;
        for(int i=1;i<=len;i++){
            if(s.charAt(i-1)!='0') dp[i]+=dp[i-1];
            if(i>=2 && s.charAt(i-2)!='0' && ((s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0') <=26)) dp[i]+=dp[i-2];
        }
        return dp[len];
    }
}
// @lc code=end

