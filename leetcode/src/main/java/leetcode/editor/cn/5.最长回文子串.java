/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // dp[i...j] i==j&&dp[i+1,j-1]
        boolean[][] dp = new boolean[s.length()][s.length()];
        // base case
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                    dp[i][j]=true;
            }
        }
        // 结果
        int L=0;
        int R=0;
        for(int i=s.length()-2;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                    dp[i][j]=s.charAt(i)==s.charAt(j)&&dp[i+1][j-1];
                    if(dp[i][j] && (j-i)>(R-L)){
                        L=i;
                        R=j;
                    }
            }
        }
        // [L...R)
        return s.substring(L,R+1);
    }
}
// @lc code=end

