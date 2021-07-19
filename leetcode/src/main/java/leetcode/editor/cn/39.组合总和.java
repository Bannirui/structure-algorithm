import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-19 18:14:32
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 18:50:14
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {

    // 结果集
    List<List<Integer>> res = new ArrayList<>();
    // 候选
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return this.res;
        }
        this.candidates = candidates;
        this.traceBack(0, new ArrayList<>(), target);
        return this.res;
    }

    private void traceBack(int index, List<Integer> path, int target) {
        // base case
        if (index == this.candidates.length) {
            // 候选数字选完了
            return;
        }
        if (target == 0) {
            // 收集
            if (!path.isEmpty()) {
                List<Integer> newPath = new ArrayList<>(path);
                this.res.add(newPath);
                return;
            }
        }
        if (target < 0) {
            // 无效解
            return;
        }
        // target>0 继续求解
        // 不选当前[index]
        traceBack(index + 1, new ArrayList<>(path), target);
        // 选当前[index]
        if (target - this.candidates[index] >= 0) {
            List<Integer> copyPath = new ArrayList<>(path);
            copyPath.add(this.candidates[index]);
            traceBack(index, copyPath, target - this.candidates[index]);
        }
    }
}
// @lc code=end
