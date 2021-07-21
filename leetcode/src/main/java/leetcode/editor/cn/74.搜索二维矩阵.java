import org.omg.PortableServer.POAPackage.WrongPolicyHelper;

/*
 * @Author: dingrui
 * @Date: 2021-07-21 16:05:44
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 16:23:55
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 右上角
        if (matrix.length == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                // 在当前行内搜索
                return this.bs(matrix[r], target);
            } else {
                r++;
            }
        }
        return false;
    }

    // 矩阵行内二分
    private boolean bs(int[] row, int target) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                // 在右边
                l = mid + 1;
            } else {
                // 在左边
                r = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end
