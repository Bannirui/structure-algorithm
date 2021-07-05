import java.util.Arrays;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-05 16:25:29
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 20:56:32
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1380 lang=java
 *
 * [1380] 矩阵中的幸运数
 */

// @lc code=start
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 行最小值
        int[] rowMin = new int[rows];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        // 列最大值
        int[] colMax = new int[cols];
        Arrays.fill(colMax, Integer.MIN_VALUE);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rowMin[r] = Math.min(rowMin[r], matrix[r][c]);
                colMax[c] = Math.max(colMax[c], matrix[r][c]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rowMin[r] == matrix[r][c] && colMax[c] == matrix[r][c]) {
                    res.add(matrix[r][c]);
                }
            }
        }
        return res;
    }
}
// @lc code=end
