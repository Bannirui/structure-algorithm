/*
 * @Author: dingrui
 * @Date: 2021-07-12 14:27:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 14:35:39
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1742 lang=java
 *
 * [1742] 盒子中小球的最大数量
 */

// @lc code=start
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        // 最大值有几位 决定盒子的编号
        int boxBits = 0;
        int high = highLimit;
        while (high > 0) {
            boxBits++;
            high /= 10;
        }
        int[] box = new int[9 * boxBits + 1];
        for (int i = lowLimit; i <= highLimit; i++) {
            int index = 0;
            int j = i;
            while (j > 0) {
                index += j % 10;
                j /= 10;
            }
            box[index]++;
        }
        int res = 0;
        for (int i = 0; i < box.length; i++) {
            res = Math.max(res, box[i]);
        }
        return res;
    }
}
// @lc code=end
