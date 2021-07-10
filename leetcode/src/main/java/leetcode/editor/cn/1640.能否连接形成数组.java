/*
 * @Author: dingrui
 * @Date: 2021-07-10 19:11:24
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 19:31:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1640 lang=java
 *
 * [1640] 能否连接形成数组
 */

// @lc code=start
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {

        for (int i = 0; i < arr.length; i++) {
            // pieces中有没有数组的首个元素是arr[i]
            int curPiecesIndex = 0;
            for (int j = 0; j < pieces[curPiecesIndex].length; j++) {
                if (arr[i] != pieces[curPiecesIndex][j]) {
                    curPiecesIndex++;
                    if (curPiecesIndex >= pieces.length) {
                        return false;
                    }
                    j = -1;
                } else {
                    i = (j + 1 < pieces[curPiecesIndex].length) ? i + 1 : i;
                }
            }
        }
        return true;
    }
}
// @lc code=end
