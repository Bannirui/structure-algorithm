/*
 * @Author: dingrui
 * @Date: 2021-06-21 13:31:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 16:46:45
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=598 lang=java
 *
 * [598] 范围求和 II
 */

// @lc code=start
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        // base case
        if (ops == null || ops.length == 0) {
            // 不操作 整个数组为初始化数组所有元素都是0
            return m * n;
        }
        // 多次操作的交集
        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
        int OP_ROWS = ops.length;
        for (int i = 0; i < OP_ROWS; i++) {
            row = Math.min(row, ops[i][0]);
            col = Math.min(col, ops[i][1]);
        }
        // [0][0]到[row][col]求和
        return row * col;
    }
}
// @lc code=end
