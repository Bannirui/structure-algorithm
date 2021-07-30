/*
 * @Author: dingrui
 * @Date: 2021-07-30 11:16:16
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-30 16:52:14
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // s1+s2-重合
        int s1 = (ax2 - ax1) * (ay2 - ay1);
        int s2 = (bx2 - bx1) * (by2 - by1);
        int union = 0;
        if (bx1 >= ax2 || bx2 <= ax1 || by1 >= ay2 || by2 <= ay1) {
            // 没有重合
        } else {
            // 有重合
            int xLeft = Math.max(ax1, bx1);
            int xRight = Math.min(ax2, bx2);
            int yUp = Math.min(ay2, by2);
            int yDown = Math.max(ay1, by1);
            union = (xRight - xLeft) * (yUp - yDown);
        }
        return s1 + s2 - union;
    }
}
// @lc code=end
