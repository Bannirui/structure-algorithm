/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // ...A ...A
        // ...A ...B
        if(word1==null || word2==null) throw new IllegalArgumentException();
        int len1=word1.length();
        int len2=word2.length();
        if(len1==0 || len2==0) return len1+len2;
        int[][] dp = new int[len1+1][len2+1];
        // base case
        for(int i=0;i<=len2;i++) dp[0][i]=i;
        for(int i=0;i<=len1;i++) dp[i][0]=i;
        for(int i=1;i<=len1;i++)
        {
            for(int j=1;j<=len2;j++)
            {
                char c1=word1.charAt(i-1);
                char c2=word2.charAt(j-1);
                if(c1==c2)
                {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]);
                }
                else
                {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

