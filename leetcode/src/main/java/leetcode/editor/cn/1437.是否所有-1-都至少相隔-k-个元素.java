/*
 * @Author: dingrui
 * @Date: 2021-07-08 10:07:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 10:27:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1437 lang=java
 *
 * [1437] 是否所有 1 都至少相隔 k 个元素
 */

// @lc code=start
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex != -1 && (i - lastIndex - 1) < k) {
                    return false;
                }
                lastIndex = i;
            }
        }
        return true;
    }
}
// @lc code=end
