/*
 * @Author: dingrui
 * @Date: 2021-07-12 16:32:39
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 16:38:58
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1791 lang=java
 *
 * [1791] 找出星型图的中心节点
 */

// @lc code=start
class Solution {
    public int findCenter(int[][] edges) {
        // 节点编号不同 出现相同的一定是中心
        if (edges[1][0] == edges[0][0] || edges[1][1] == edges[0][0]) {
            return edges[0][0];
        }
        if (edges[1][0] == edges[0][1] || edges[1][1] == edges[0][1]) {
            return edges[0][1];
        }
        return 0;
    }
}
// @lc code=end
