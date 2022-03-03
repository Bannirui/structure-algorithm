/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 左下角
        int ROWS=matrix.length;
        int COLS=matrix[0].length;
        int r=ROWS-1;
        int c=0;
        while(r>=0&&r<ROWS&&c>=0&&c<COLS){
            int cur=matrix[r][c];
            if(cur==target) return true;
            if(cur>target) r--;
            else c++;
        }
        return false;
    }
}
// @lc code=end

