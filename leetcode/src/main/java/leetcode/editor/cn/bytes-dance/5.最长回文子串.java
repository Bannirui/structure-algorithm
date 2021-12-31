/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) return "";
        /*
        dp[i][j] [i...j] is palindrome or not
         */
        boolean[][] dp = new boolean[len][len];
        // base case
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(i>=j) dp[i][j]=true;
            }
        }
        int maxLen = Integer.MIN_VALUE; // record max sub length
        int start=-1;
        int end=-1;
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(dp[i][j] && (j-i)>maxLen){
                    maxLen = j-i;
                    start=i;
                    end=j;
                }
            }
        }
        if(start==-1 && end==-1) return "";
        return s.substring(start, end+1);
    }
}
// @lc code=end

