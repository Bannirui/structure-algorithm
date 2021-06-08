package leetcode.editor.cn;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics 数组 动态规划
// 👍 896 👎 0

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        // int[] row1 = new int[]{1, 3, 1};
        // int[] row2 = new int[]{1, 5, 1};
        // int[] row3 = new int[]{4, 2, 1};
        // int[][] grid = new int[][]{row1, row2, row3};
        // solution.minPathSum(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            // dp[i][j]: (0,0)->(i,j)的最小和
            int ROW = grid.length;
            int COL = grid[0].length;
            int[][] dp = new int[ROW][COL];
            // 填表顺序(0,0)->(i,j)
            dp[0][0] = grid[0][0];
            // 0行
            for (int i = 1; i < COL; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            // 0列
            for (int i = 1; i < ROW; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            // 普遍位置
            for (int i = 1; i < ROW; i++) {
                for (int j = 1; j < COL; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[ROW - 1][COL - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
