import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-30 16:57:14
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 17:27:19
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1030 lang=java
 *
 * [1030] 距离顺序排列矩阵单元格
 */

// @lc code=start
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                res[r * cols + c] = new int[] { r, c };
            }
        }
        // sort
        Arrays.sort(res, (arr1, arr2) -> {
            int len1 = Math.abs(arr1[0] - rCenter) + Math.abs(arr1[1] - cCenter);
            int len2 = Math.abs(arr2[0] - rCenter) + Math.abs(arr2[1] - cCenter);
            return len1 - len2;
        });
        return res;
    }
}
// @lc code=end
