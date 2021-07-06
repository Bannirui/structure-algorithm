/*
 * @lc app=leetcode.cn id=1275 lang=java
 *
 * [1275] 找出井字棋的获胜者
 */

// @lc code=start
class Solution {
    public String tictactoe(int[][] moves) {
        int len = moves.length;
        // 0-2=行 3-5=列 6-7=斜
        int[] helpA = new int[8];
        int[] helpB = new int[8];
        // 先a后b
        for (int r = 0; r < len; r++) {
            if (r % 2 == 0) {
                // a落子
                // 行
                helpA[moves[r][0]]++;
                // 列
                helpA[moves[r][1] + 3]++;
                // 斜
                if (moves[r][0] == moves[r][1]) {
                    helpA[6]++;
                }
                if (moves[r][0] + moves[r][1] == 2) {
                    helpA[7]++;
                }

            } else {
                // b落子
                // 行
                helpB[moves[r][0]]++;
                // 列
                helpB[moves[r][1] + 3]++;
                // 斜
                if (moves[r][0] == moves[r][1]) {
                    helpB[6]++;
                }
                if (moves[r][0] + moves[r][1] == 2) {
                    helpB[7]++;
                }
            }
            if (helpA[moves[r][0]] == 3 || helpA[moves[r][1] + 3] == 3 || helpA[6] == 3 || helpA[7] == 3) {
                return "A";
            }
            if (helpB[moves[r][0]] == 3 || helpB[moves[r][1] + 3] == 3 || helpB[6] == 3 || helpB[7] == 3) {
                return "B";
            }

        }
        // 游戏没结束
        return len == 9 ? "Draw" : "Pending";
    }
}
// @lc code=end
