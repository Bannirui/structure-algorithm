/*
 * @Author: dingRui
 * @Date: 2021-08-02 14:48:30
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-02 15:12:01
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // bst
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int minRowOrCol = Math.min(matrix.length, matrix[0].length);
        for (int r = 0; r < minRowOrCol; r++) {
            // 搜索r行
            boolean rowSearch = this.bst(matrix, target, r, true);
            // 搜索r列
            boolean colSearch = this.bst(matrix, target, r, false);
            if (rowSearch || colSearch) {
                return true;
            }
        }
        return false;
    }

    private boolean bst(int[][] matrix, int target, int start, boolean rowSearch) {
        int low = start;
        int high = rowSearch ? matrix.length - 1 : matrix[0].length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (rowSearch) {
                // 搜索start行
                int cur = matrix[mid][start];
                if (cur == target) {
                    return true;
                } else if (cur < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // 搜索start列
                int cur = matrix[start][mid];
                if (cur == target) {
                    return true;
                } else if (cur < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
// @lc code=end
