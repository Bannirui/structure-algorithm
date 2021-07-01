/*
 * @Author: dingrui
 * @Date: 2021-07-01 08:55:20
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 13:22:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1033 lang=java
 *
 * [1033] 移动石子直到连续
 */

// @lc code=start
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        // abc相对升序
        int tmp;
        // ab升序
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        // ac升序
        if (a > c) {
            tmp = a;
            a = c;
            c = tmp;
        }
        // bc升序
        if (b > c) {
            tmp = b;
            b = c;
            c = tmp;
        }
        if (b == a + 1) {
            if (c == b + 1) {
                return new int[] { 0, 0 };
            } else {
                return new int[] { 1, c - b - 1 };
            }
        } else {
            if (c == b + 1) {
                return new int[] { 1, b - a - 1 };
            } else {
                if (b == a + 2 || c == b + 2) {
                    return new int[] { 1, (c - b - 1) + (b - a - 1) };
                } else {
                    return new int[] { 2, (c - b - 1) + (b - a - 1) };
                }
            }
        }

    }
}
// @lc code=end
