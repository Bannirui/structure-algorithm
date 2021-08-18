import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingRui
 * @Date: 2021-08-18 10:16:08
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-18 15:46:05
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {

    private List<Integer> res = new ArrayList<>();;

    private int limit;

    public List<Integer> lexicalOrder(int n) {
        this.limit = n;
        for (int i = 1; i <= 9; i++) {
            this.dfs(i);
        }
        return this.res;
    }

    private void dfs(int i) {
        // base case
        if (i > this.limit) {
            return;
        }
        this.res.add(i);
        for (int j = 0; j <= 9; j++) {
            this.dfs(i * 10 + j);
        }
    }
}
// @lc code=end
