import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution
{

    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix)
    {
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol)
        {
            this.orderByLevel(matrix, new int[] {startRow, startCol}, new int[] {endRow, endCol});
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return this.res;
    }

    private void orderByLevel(int[][] matrix, int[] start, int[] end)
    {
        if (start[0] == end[0])
        {
            // 只有一行
            for (int i = start[1]; i <= end[1]; i++)
            {
                this.res.add(matrix[start[0]][i]);
            }
        }
        else
        {
            // 左上 右上 右下 左下 左上
            for (int i = start[1]; i < end[1]; i++)
            {
                this.res.add(matrix[start[0]][i]);
            }
            for (int i = start[0]; i < end[0]; i++)
            {
                this.res.add(matrix[i][end[1]]);
            }
            for (int i = end[1]; i > start[1]; i--)
            {
                this.res.add(matrix[end[0]][i]);
            }
            for (int i = end[0]; i > start[0]; i--)
            {
                this.res.add(matrix[i][start[1]]);
            }
        }
    }
}
// @lc code=end
