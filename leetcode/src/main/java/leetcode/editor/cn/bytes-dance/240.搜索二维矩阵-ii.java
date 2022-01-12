/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS=0, COLS=0;
        if(matrix==null || (ROWS=matrix.length)==0 || (COLS=matrix[0].length)==0) return false;
        // [0, COLS-1]
        int row=0, col=COLS-1;
        while(row<ROWS && col>=0){
            int curV = matrix[row][col];
            if(curV==target) return true;
            if(curV<target) row++;
            else col--;
        }
        return false;
    }
}
// @lc code=end

