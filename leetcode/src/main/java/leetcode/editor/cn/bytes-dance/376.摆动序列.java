/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return 0;
        // [0][...] up
        // [1][...] down
        int[][] dp = new int[2][len];
        // base case
        dp[0][0]=1;
        dp[1][0]=1;
        for(int i=1;i<len;i++){
            int cur = nums[i];
            int pre = nums[i-1];
            if(cur>pre){
                dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]+1);
                dp[1][i] = dp[1][i-1];
            }else if(cur<pre){
                dp[0][i] = dp[0][i-1];
                dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1]+1);
            }else{
                dp[0][i] = dp[0][i-1];
                dp[1][i] = dp[1][i-1];
            }
        }
        return Math.max(dp[0][len-1], dp[1][len-1]);
    }
}
// @lc code=end

