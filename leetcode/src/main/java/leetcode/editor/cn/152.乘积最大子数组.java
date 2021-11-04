/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // dp[i]以i结尾的最大/最小乘积
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        // base case
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        // 推导
        int res = dpMax[0];
        for(int i=1;i<nums.length;i++){
            // i跟以i-1结尾的序列连上 或者 i自己形成序列
            dpMax[i] = Math.max(Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i]);
            res=Math.max(res, dpMax[i]);
        }
        return res;
    }
}
// @lc code=end

