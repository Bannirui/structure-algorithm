/*
 * @Author: dingrui
 * @Date: 2021-07-05 15:49:44
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 16:21:23
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1351 lang=java
 *
 * [1351] 统计有序矩阵中的负数
 */

// @lc code=start
class Solution {
    public int countNegatives(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int res = 0;
        // 遍历行
        int col = COLS - 1;
        flag: for (int r = 0; r < ROWS; r++) {
            // 遍历列 从后往前 找到第一个非负数 记录上一行找到的非负位置
            for (int c = col; c >= 0; c--) {
                if (grid[r][c] >= 0) {
                    // 找到了每行第一个非负 结算该行贡献结果 更新col 下一行往前找的基准就是col
                    res += (COLS - (c + 1));
                    col = c;
                    continue flag;
                } else {
                    if (c == 0) {
                        // 整行都是负数
                        res += COLS;
                        continue flag;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
