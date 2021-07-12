/*
 * @Author: dingrui
 * @Date: 2021-07-12 17:56:53
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 18:00:57
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1822 lang=java
 *
 * [1822] 数组元素积的符号
 */

// @lc code=start
class Solution {
    public int arraySign(int[] nums) {
        // 数量 [0]=0 [1]=负数
        int[] numCount = new int[2];
        for (int num : nums) {
            if (num == 0) {
                numCount[0]++;
            }
            if (num < 0) {
                numCount[1]++;
            }
        }
        // 判断正负
        if (numCount[0] > 0) {
            return 0;
        }
        return numCount[1] % 2 == 0 ? 1 : -1;
    }
}
// @lc code=end
