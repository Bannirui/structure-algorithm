/*
 * @Author: dingrui
 * @Date: 2021-07-22 22:24:05
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-23 16:56:41
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        // 遍历异或一趟之后xor=a^b
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 在xor的二进制中任意取到一位等于1的 再进行异或 可以区分出a b
        int aim = 1;
        while ((xor & aim) == 0) {
            aim <<= 1;
        }
        // aim的最高位1体现了xor最低位1的位置
        int a = 0, b = 0;
        for (int num : nums) {
            if ((aim & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] { a, b };
    }
}
// @lc code=end
