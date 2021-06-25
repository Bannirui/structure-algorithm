/*
 * @Author: dingrui
 * @Date: 2021-06-25 14:01:57
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-25 14:39:25
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int cldColor = image[sr][sc];
        infection(image, sr, sc, cldColor, newColor, rows, cols);
        return image;
    }

    private void infection(int[][] image, int sr, int sc, int oldColor, int newColor, int rows, int cols) {
        // base case
        if (sr < 0 || sr >= rows || sc < 0 || sc >= cols || image[sr][sc] != oldColor || image[sr][sc] == newColor) {
            return;
        }
        // 换颜色
        image[sr][sc] = newColor;
        // 上下左右的邻居
        infection(image, sr - 1, sc, oldColor, newColor, rows, cols);
        infection(image, sr + 1, sc, oldColor, newColor, rows, cols);
        infection(image, sr, sc - 1, oldColor, newColor, rows, cols);
        infection(image, sr, sc + 1, oldColor, newColor, rows, cols);
    }
}
// @lc code=end
