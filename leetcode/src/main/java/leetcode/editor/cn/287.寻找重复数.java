/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // [1...n]落在[0...n-1]脚标上 一一对应
        for (int i = 0; i < nums.length;) {
            int curNum = nums[i];
            if (curNum - 1 == i) {
                // 当前脚标已经对应
                i++;
            } else {
                // 判断正确应该待的脚标上数字是否正确
                if (nums[curNum - 1] == curNum) {
                    // 当前这个数字就是多余出来的重复
                    return curNum;
                } else {
                    // 当前脚标不对应 把当前数字挪到正确脚标上 移动过来的新的数字不确定脚标是否对应
                    int target = nums[curNum - 1];
                    nums[curNum - 1] = curNum;
                    nums[i] = target;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
