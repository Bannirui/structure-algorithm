package leetcode.editor.cn;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//
//
// 示例 1：
//
//
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
//
// 示例 2：
//
//
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
//
//
//
//
// 提示：
//
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] 为 0 或 1
//
// Related Topics 数组 动态规划
// 👍 563 👎 0

public class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // dp[i]: (0,0)到(ROW,i)的方法
            int ROW = obstacleGrid.length;
            int COL = obstacleGrid[0].length;
            // 数组初始化都是0
            int[] dp = new int[COL];
            // 是否有障碍物
            dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for (int i = 0; i < ROW; i++) {
                // 一行一行遍历 每一行保留对应列的记录 当行遍历完每一列保留的就是最后一行对应列的记录
                for (int j = 0; j < COL; j++) {
                    // 一直把列j遍历完
                    if (obstacleGrid[i][j] == 1) {
                        // 障碍物
                        dp[j] = 0;
                        continue;
                    }
                    if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
            // 表构建结束了 最右下角就是求解
            return dp[COL - 1];
        }

        // 方法超时 需要优化 压缩空间
        public int uniquePathsWithObstacles02(int[][] obstacleGrid) {
            // dp[i][j]: 从(0,0)->(i,j)的路径方法 表中-1表示障碍物
            int ROW = obstacleGrid.length;
            int COL = obstacleGrid[0].length;
            // 数组初始化都是0
            int[][] dp = new int[ROW][COL];
            // 0行
            for (int i = 0; i < COL; i++) {
                if (obstacleGrid[0][i] == 1) {
                    // 障碍物
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = 1;
                }
            }
            // 0列
            for (int j = 0; j < ROW; j++) {
                if (obstacleGrid[j][0] == 1) {
                    // 障碍物
                    dp[j][0] = 0;
                } else {
                    dp[j][0] = 1;
                }
            }
            for (int i = 1; i < ROW; i++) {
                for (int j = 1; j < COL; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        // 障碍物
                        dp[i][j] = 0;
                    } else {
                        // 要么从上面下来 要么从左面过来
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            // 表构建结束了 最右下角就是求解
            return dp[ROW - 1][COL - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
