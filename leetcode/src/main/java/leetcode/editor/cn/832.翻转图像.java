/*
 * @Author: dingrui
 * @Date: 2021-06-28 16:28:40
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 16:51:25
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        for (int r = 0; r < rows; r++) {
            int firstCol = 0, lastCol = cols - 1;
            // 水平翻转
            while (firstCol <= lastCol) {
                int tmp = image[r][firstCol];
                image[r][firstCol] = image[r][lastCol];
                image[r][lastCol] = tmp;
                firstCol++;
                lastCol--;
            }
            // 翻转
            for (int c = 0; c < cols; c++) {
                image[r][c] = 1 - image[r][c];
            }
        }
        return image;
    }
}
// @lc code=end
