import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-17 11:33:11
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-17 11:50:01
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int numTrees(int n) {
        return dfs(n);
    }

    // 节点数量n 有多少种二叉搜索树
    private int dfs(int num) {
        // base case
        if (num <= 1) {
            return 1;
        }

        // 记忆化搜索
        if (this.cache.containsKey(num)) {
            return this.cache.get(num);
        }
        int count = 0;
        for (int i = 0; i < num; i++) {
            // 左树+右树
            count += (dfs(i) * dfs(num - i - 1));
        }
        this.cache.put(num, count);
        return count;
    }
}
// @lc code=end
