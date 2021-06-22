import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-06-22 14:20:22
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 14:39:26
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        int estimateSum = ((1 + len) * len) >>> 1;
        int actualSum = 0;
        int repeatedNum = 0;
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                repeatedNum = nums[i];
            } else {
                set.add(nums[i]);
            }
            actualSum += nums[i];
        }
        return new int[] { repeatedNum, estimateSum - (actualSum - repeatedNum) };
    }
}
// @lc code=end
