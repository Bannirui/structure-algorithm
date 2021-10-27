/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 左下角到右上角
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int curNum = matrix[row][col];
            if (curNum == target) {
                // 找到了
                return true;
            } else if (curNum > target) {
                // 左边列
                col--;
            } else {
                // 下边行
                row++;
            }
        }
        return false;
    }
}
// @lc code=end
