/*
 * @Author: dingrui
 * @Date: 2021-06-22 15:41:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 16:00:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] img) {
        // 固定窗口大小周围8个=3*3
        int rows = img.length;
        int cols = img[0].length;
        int[][] res = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 遍历到了[row][col] 此时的窗口就是[row-1,row+1][col-1,col+1]
                int sum = 0, count = 0;
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        // 越界
                        if (0 <= i && i < rows && 0 <= j && j < cols) {
                            sum += img[i][j];
                            count++;
                        }
                    }
                }
                // 平均值
                res[row][col] = (sum / count);
            }
        }
        return res;
    }
}
// @lc code=end
