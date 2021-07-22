import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-22 21:12:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 21:46:16
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.dfs(1, k, n, new ArrayList<>());
        return this.res;
    }

    // 在[1...9]中选countTotal个数字 不重复 总和为sumTarget
    // 现在已经选了count个和为sum
    private void dfs(int index, int countTotal, int sumTarget, List<Integer> path) {
        // base case
        if (path.size() == countTotal && 0 == sumTarget) {
            // 收集答案
            this.res.add(new ArrayList<Integer>(path));
            return;
        }
        if (path.size() > countTotal || sumTarget < 0) {
            return;
        }
        // 当前数字决策
        for (int i = index; i <= 9; i++) {
            // 要当前数字
            List<Integer> copyPath = new ArrayList<>(path);
            copyPath.add(i);
            dfs(i + 1, countTotal, sumTarget - i, copyPath);
        }
    }
}
// @lc code=end
