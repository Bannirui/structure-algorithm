/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // bs
        // 从右上角开始
        int ROWS=matrix.length;
        int COLS=matrix[0].length;
        int r=0;
        int c=COLS-1;
        while(r<ROWS&&c>=0){
            int curVal = matrix[r][c];
            if(curVal==target){
                // 找到了
                return true;
            }else if(curVal<target){
                // 搜索下面行
                r++;
            }else{
                // 搜索左面列
                c--;
            }
        }
        return false;
    }
}
// @lc code=end

