/*
 * @Author: dingrui
 * @Date: 2021-06-30 13:15:01
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 13:32:08
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        // 法官：只进不出
        int[] out = new int[n + 1];
        int[] in = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            int trustOut = trust[i][0];
            int trustIn = trust[i][1];
            out[trustOut]++;
            in[trustIn]++;
        }
        // from 1
        for (int i = 1; i <= n; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end
