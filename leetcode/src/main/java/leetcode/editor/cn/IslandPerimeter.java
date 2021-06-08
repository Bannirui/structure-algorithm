package leetcode.editor.cn;

//给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
//
// 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//输出：16
//解释：它的周长是上面图片中的 16 个黄色的边
//
// 示例 2：
//
//
//输入：grid = [[1]]
//输出：4
//
//
// 示例 3：
//
//
//输入：grid = [[1,0]]
//输出：4
//
//
//
//
// 提示：
//
//
// row == grid.length
// col == grid[i].length
// 1 <= row, col <= 100
// grid[i][j] 为 0 或 1
//
// Related Topics 哈希表
// 👍 409 👎 0

public class IslandPerimeter {
    public static void main(String[] args) {
        Solution solution = new IslandPerimeter().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int islandPerimeter(int[][] grid) {
            // dfs搜索
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // 找到岛屿 开始遍历
                    if (grid[i][j] == 1) {
                        return dfs(grid, i, j);
                    }
                }
            }
            // 整个网格一个岛都没找到
            return 0;
        }

        // grid: 遍历的目标
        // row: 当前的行坐标
        // col: 当前的列坐标
        private int dfs(int[][] grid, int row, int col) {
            // 表的行数 列数
            int ROW = grid.length;
            int COL = grid[0].length;// 坐标不合理 越界了 从岛屿走向网格边界 这个边加入周长
            if (!(row >= 0 && row < ROW && col >= 0 && col < COL)) {
                return 1;
            }
            // 岛屿走向了水 这个边加入周长
            if (grid[row][col] == 0) {
                return 1;
            }
            // 岛屿已经遍历过 不加入周长
            if (grid[row][col] == 2) {
                return 0;
            }
            // 岛屿向四周遍历 标记该岛屿已经遍历过
            grid[row][col] = 2;
            return dfs(grid, row - 1, col) +
                    dfs(grid, row + 1, col) +
                    dfs(grid, row, col - 1) +
                    dfs(grid, row, col + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
