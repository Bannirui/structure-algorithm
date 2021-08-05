/*
 * @Author: dingRui
 * @Date: 2021-08-05 10:08:42
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-05 10:40:21
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {

    int[][] sums = null;

    public NumMatrix(int[][] matrix) {
        // 前缀和 sums[i][j] 表示的是matrix中[0...i-1][0...j-1]的和
        if (matrix.length > 0) {
            int length = matrix.length, width = matrix[0].length;
            this.sums = new int[length + 1][width + 1];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    // 开始求和
                    sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.sums == null) {
            return -1;
        }
        // matrix中[row1...row2][col1...col2]的和
        return this.sums[row2 + 1][col2 + 1] - this.sums[row1][col2 + 1] - this.sums[row2 + 1][col1]
                + this.sums[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
