import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-05 14:55:12
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 11:44:06
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1260 lang=java
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        for (; k > 0; k--) {
            int[][] help = new int[grid.length][grid[0].length];
            // 列后移
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length - 1; c++) {
                    help[r][c + 1] = grid[r][c];
                }
            }
            // 每行最后一列->下一行列首
            for (int r = 0; r < grid.length - 1; r++) {
                help[r + 1][0] = grid[r][grid[0].length - 1];
            }
            // 右下角->左上角
            help[0][0] = grid[grid.length - 1][grid[0].length - 1];
            grid = help;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> ROW = new ArrayList<>();
            for (int num : row) {
                ROW.add(num);
            }
            res.add(ROW);
        }
        return res;
    }
}
// @lc code=end
