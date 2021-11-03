/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
        // dp[i] 以i结尾的[0...i]可以被拆解
        boolean[] dp = new boolean[s.length()+1];
        // base case
        dp[0]=true;
        // 推导
        for(int i=1;i<=s.length();i++){
            // 但凡能在[0...i]中找到[0...j]可拆解 并且[j+1...i]是个单词 就可以
            for(int j=0;j<i;j++){
                // 后半段的单词
                String word = s.substring(j, i);
                if(dp[j]&&set.contains(word)){
                    // [0...i]可拆解
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end

