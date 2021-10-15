/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution
{
    public void setZeroes(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 列上是否有0
        boolean[] colExistZero = new boolean[cols];
        // 行上是否有0
        boolean[] rowExistZero = new boolean[rows];
        // 遍历
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (matrix[i][j] == 0)
                {
                    colExistZero[j] = true;
                    rowExistZero[i] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (colExistZero[j] || rowExistZero[i])
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end
