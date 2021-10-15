/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution
{
    public void rotate(int[][] matrix)
    {
        // n*n 1<=n<=20
        int n = matrix.length;
        int start = 0;
        int end = n - 1;
        while (start < end)
        {
            // 旋转一层
            this.rotateByLevel(matrix, start, start, end, end);
            start++;
            end--;
        }
    }

    // matrix中按照外圈层级旋转
    private void rotateByLevel(int[][] matrix, int startRow, int startCol, int endRow, int endCol)
    {
        for (int i = 0; startCol + i < endCol; i++)
        {
            // 存储左列的值
            int tmpVal = matrix[endRow - i][startCol];
            // 左列=下行
            matrix[endRow - i][startCol] = matrix[endRow][endCol - i];
            // 下行=右列
            matrix[endRow][endCol - i] = matrix[startRow + i][endCol];
            // 右列=上行
            matrix[startRow + i][endCol] = matrix[startRow][startCol + i];
            // 上行=左列
            matrix[startRow][startCol + i] = tmpVal;
        }
    }
}
// @lc code=end
