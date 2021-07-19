import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-19 20:01:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 20:27:00
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {

    // 结果集
    private Set<List<Integer>> res = new HashSet<>();

    // 候选
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.backTrace(0, new ArrayList<>(), target);
        return new ArrayList<>(this.res);
    }

    private void backTrace(int index, List<Integer> path, int target) {
        // base case
        if (target == 0) {
            // 收集答案
            this.res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index >= this.candidates.length) {
            return;
        }
        // startIndex这个数字要或者不要两种决策
        backTrace(index + 1, path, target);
        if (target - this.candidates[index] >= 0) {
            List<Integer> copyPath = new ArrayList<>(path);
            copyPath.add(this.candidates[index]);
            backTrace(index + 1, copyPath, target - this.candidates[index]);
        }
    }
}
// @lc code=end
