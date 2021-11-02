/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // trace
        this.trace(candidates,0, target, new ArrayList<>());
        return this.res;
    }

    // 从candiates中找方案 和为target
    private void trace(int[] candidates,int idx, int remain, List<Integer> path){
        // base case
        if(idx==candidates.length){
            return;
        }
        if(remain==0 && !path.isEmpty()){
            // 收集方案
            this.res.add(new ArrayList<>(path));
            return;
        }
        // 在candidates中找数字 和为left
        int curVal = candidates[idx];
        // 选用当前值
        // 保证remain>=0
        if(remain-curVal>=0){
            List<Integer> useCurTmpPath = new ArrayList<>(path);
            useCurTmpPath.add(curVal);
            this.trace(candidates,idx, remain-curVal, useCurTmpPath);
        }
        
        // 不选用当前值
        List<Integer> discardCurTmpPath = new ArrayList<>(path);
        this.trace(candidates,idx+1, remain, discardCurTmpPath);
    }
}
// @lc code=end

