/*
 * @Author: dingRui
 * @Date: 2021-08-22 15:22:23
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-23 17:37:08
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=393 lang=java
 *
 * [393] UTF-8 编码验证
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        int[] data = new int[1];
        data[0] = 1;
        new Solution().validUtf8(data);
    }

    public boolean validUtf8(int[] data) {
        // 高位几个1 表示几位 紧挨着首个需要处理多少个数字
        int highOneCounts = 0;
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        for (int num : data) {
            if (highOneCounts == 0) {
                int mask = 1 << 7;
                while ((num & mask) != 0) {
                    // 找到一个高位1
                    highOneCounts++;
                    mask >>= 1;
                }
                if (highOneCounts == 0) {
                    continue;
                }
                if (highOneCounts > 4 || highOneCounts == 1) {
                    return false;
                }
            } else {
                if (((num & mask1) != 0) && ((num & mask2) == 0)) {
                    // 10开头的
                } else {
                    return false;
                }
            }
            highOneCounts--;
        }
        return highOneCounts == 0;
    }
}
// @lc code=end
