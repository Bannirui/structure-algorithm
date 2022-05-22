/*
 * @lc app=leetcode.cn id=807 lang=java
 *
 * [807] 保持城市天际线
 */

// @lc code=start
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ROW=0, COL=0;
        if(grid==null || (ROW=grid.length)==0 || (COL=grid[0].length)==0) throw new IllegalArgumentException();
        // 每行最大值
        int[] maxValPerRow = new int[ROW];
        // 每列最大值
        int[] maxValPerCol = new int[COL];
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                maxValPerRow[i] = Math.max(maxValPerRow[i], grid[i][j]);
                maxValPerCol[j] = Math.max(maxValPerCol[j], grid[i][j]);
            }
        }

        int ret=0;
        for(int i=0; i<ROW; i++)
            for(int j=0; j<COL; j++)
                ret+=(Math.min(maxValPerRow[i], maxValPerCol[j])-grid[i][j]);
        
        return ret;
    }
}
// @lc code=end

