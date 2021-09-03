/*
 * @Author: dingRui
 * @Date: 2021-09-03 16:05:08
 * @LastEditors: dingRui
 * @LastEditTime: 2021-09-03 17:39:05
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 2) {
            return false;
        }
        if (len == 2) {
            return nums[0] == nums[1];
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        // 和为奇数无法实现
        if (sum % 2 != 0) {
            return false;
        }

        // 和为偶数 最大值超过和的一半 无法实现
        int half = 0;
        if (max > (half = sum / 2)) {
            return false;
        }

        // dp[i][j]语义: 在nums中[0...i]中能够找到组合的和为j
        boolean[][] dp = new boolean[len][half + 1];
        // base case
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            for (int j = 1; j <= half; j++) {
                if (j >= cur) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - cur];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][half];
    }
}
// @lc code=end
