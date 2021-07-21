/*
 * @Author: dingrui
 * @Date: 2021-07-21 16:26:50
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 17:32:02
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {

    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        // 从左上角[0][0]出发
        this.board = board;
        this.word = word;
        boolean[][] used = new boolean[board.length][board[0].length];
        // 随便从一个点出发
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean find = this.dfs(i, j, used, 0);
                if (find) {
                    return true;
                }
            }
        }
        return false;
    }

    // 在二维数组中从[row][col]为出发点 找字符串word[index...]
    private boolean dfs(int row, int col, boolean[][] used, int index) {
        // base case
        if (index == this.word.length()) {
            // 字符串已经遍历完
            return true;
        }
        // 数组越界
        if (row < 0 || row >= this.board.length || col < 0 || col >= this.board[0].length) {
            return false;
        }
        // 当前位置[row][col]
        char curChar = this.board[row][col];
        if (curChar != this.word.charAt(index)) {
            return false;
        }
        // 字符相等 继续
        // 深拷贝 替代现场还原
        boolean[][] copyUsed = this.copyArr(used);
        if (copyUsed[row][col]) {
            // 已经被使用过
            return false;
        }
        // 使用掉当前字符
        copyUsed[row][col] = true;
        // 找到一个相同字符 继续下一个字符
        boolean up = dfs(row - 1, col, copyUsed, index + 1);
        boolean down = dfs(row + 1, col, copyUsed, index + 1);
        boolean left = dfs(row, col - 1, copyUsed, index + 1);
        boolean right = dfs(row, col + 1, copyUsed, index + 1);
        return up || down || left || right;
    }

    private boolean[][] copyArr(boolean[][] used) {
        boolean[][] res = new boolean[used.length][used[0].length];
        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used[0].length; j++) {
                res[i][j] = used[i][j];
            }
        }
        return res;
    }
}
// @lc code=end
