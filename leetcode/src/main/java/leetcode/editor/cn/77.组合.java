import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-14 10:52:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 11:34:15
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int limitCount = 0;

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return this.res;
        }
        this.limitCount = k;
        List<Integer> path = new ArrayList<>();
        this.dfs(n, 1, path);
        return this.res;
    }

    // 从start开始
    // 在[start...n]找limitCount个数放到path
    // path里面收集到了limitCount个就放到res中
    private void dfs(int n, int start, List<Integer> path) {
        // base case
        // 收集
        if (path.size() == this.limitCount) {
            this.res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 替代现场还原
            List<Integer> copyPath = new ArrayList<>(path);
            copyPath.add(i);
            dfs(n, i + 1, copyPath);
        }

    }
}
// @lc code=end
