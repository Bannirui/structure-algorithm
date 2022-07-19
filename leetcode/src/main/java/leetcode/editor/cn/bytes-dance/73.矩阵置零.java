/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=0, n=0;
        if(matrix==null || (m=matrix.length)==0 || (n=matrix[0].length)==0) throw new IllegalArgumentException();
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        // record
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) row[i]=col[j]=true;
            }
        }
        // update
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i] || col[j]) matrix[i][j]=0;
            }
        }
    }
}
// @lc code=end

