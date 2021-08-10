
/*
 * @Author: dingRui
 * @Date: 2021-08-10 13:53:10
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-10 15:31:54
 * @Description: 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // dp[i] 在[0...n]中以i为最大值的有效子集最大长度
        int[] dp = new int[nums.length];
        // 升序
        Arrays.sort(nums);
        // base case
        Arrays.fill(dp, 1);
        int maxLen = 1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新子集最大长度
            if (dp[i] > maxLen) {
                // dp[i]已经填完
                maxLen = Math.max(maxLen, dp[i]);
                maxVal = Math.max(maxVal, nums[i]);
            }
        }
        // 获取了以i为最大值的最长子集长度
        List<Integer> res = new ArrayList<>();
        if (maxLen == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = nums.length - 1; i >= 0 && maxLen > 0; i--) {
            if (dp[i] == maxLen && maxVal % nums[i] == 0) {
                // 收集到了子集中一个元素
                res.add(0, nums[i]);
                maxLen--;
                maxVal = nums[i];
            }
        }
        return res;
    }
}
// @lc code=end
