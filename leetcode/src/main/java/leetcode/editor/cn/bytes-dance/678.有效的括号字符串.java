/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int len = 0;
        if(s==null || (len=s.length())==0) throw new IllegalArgumentException();
        boolean[][] dp = new boolean[len][len];
        // base case
        // len==1
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='*') dp[i][i]=true;
        }
        // len==2
        for(int i=1;i<len;i++){
            char pre=s.charAt(i-1);
            char cur=s.charAt(i);
            dp[i-1][i]=((pre=='('||pre=='*')&&(cur==')'||cur=='*'));
        }
        // len>=3
        for(int i=len-3;i>=0;i--){
            char l=s.charAt(i);
            for(int j=i+2;j<len;j++){
                char r=s.charAt(j);
                if((l=='('||l=='*')&&(r==')'||r=='*')) dp[i][j]=dp[i+1][j-1];
                for(int k=i;k<j&&!dp[i][j];k++)dp[i][j]=dp[i][k]&&dp[k+1][j];
            }
        }
        return dp[0][len-1];
    }
}
// @lc code=end

