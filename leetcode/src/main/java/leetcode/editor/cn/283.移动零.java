/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // [0...i-1]已经排好 当前脚标i
            int curNum = nums[i];
            if (curNum == 0) {
                // 0
                // [i+1...]找第一个不是0的 调换位置
                boolean findFirstNotZero = false;
                int j = i;
                for (; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        // 找到了第一个不是0的
                        findFirstNotZero = true;
                        break;
                    }
                }
                if (findFirstNotZero) {
                    // 交换位置
                    nums[i] = nums[j];
                    nums[j] = curNum;
                } else {
                    // 说明[i...]都是0
                    break;
                }
            } else {
                // 不是0
                i++;
            }
        }
    }
}
// @lc code=end
