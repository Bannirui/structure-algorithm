/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // 有序状态下 中间索引
        Arrays.sort(nums);
        return nums[(nums.length-1)>>>1];
    }
}
// @lc code=end

