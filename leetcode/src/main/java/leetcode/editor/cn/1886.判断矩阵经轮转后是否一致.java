import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-13 10:26:18
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-13 10:43:01
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1886 lang=java
 *
 * [1886] 判断矩阵经轮转后是否一致
 */

// @lc code=start
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // 旋转第4次又变成自己 在4次旋转间是否能形成target
        boolean[] res = new boolean[4];
        int[][] tmp = mat;
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(tmp = rotate(tmp), target)) {
                return true;
            }
        }
        return false;
    }

    // 顺时针旋转90度
    private int[][] rotate(int[][] mat) {
        int[][] res = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                res[j][i] = mat[mat.length - i - 1][j];
            }
        }
        return res;
    }
}
// @lc code=end
