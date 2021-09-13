/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {

    private int[][] grid;

    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        this.grid = grid;
        int ROW = grid.length;
        int COL = grid[0].length;
        return this.dfs(0, ROW - 1, 0, COL - 1);
    }

    // 在grid二维数组[rowStart, rowEnd]到[colStart, colEnd]里面玩深搜
    private Node dfs(int rowStart, int rowEnd, int colStart, int colEnd) {
        // 叶子节点判断
        boolean isLeaf = true;
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (this.grid[i][j] != this.grid[rowStart][colStart]) {
                    isLeaf = false;
                    break;
                }
            }
        }
        Node node = new Node();
        node.isLeaf = isLeaf;
        node.val = this.grid[rowStart][colStart] == 1;
        if (!isLeaf) {
            // 递归
            node.topLeft = this.dfs(rowStart, rowStart + (rowEnd - rowStart - 1) / 2, colStart,
                    colStart + (colEnd - colStart - 1) / 2);
            node.topRight = this.dfs(rowStart, rowStart + (rowEnd - rowStart - 1) / 2,
                    colStart + (colEnd - colStart - 1) / 2 + 1, colEnd);
            node.bottomLeft = this.dfs(rowStart + (rowEnd - rowStart - 1) / 2 + 1, rowEnd, colStart,
                    colStart + (colEnd - colStart - 1) / 2);
            node.bottomRight = this.dfs(rowStart + (rowEnd - rowStart - 1) / 2 + 1, rowEnd,
                    colStart + (colEnd - colStart - 1) / 2 + 1, colEnd);
        }
        return node;
    }
}
// @lc code=end
