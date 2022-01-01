/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {

    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.traceBack(candidates, 0, target, new ArrayList<>());
        return this.ret;
    }

    private void traceBack(int[] candidates, int idx, int target, List<Integer> path){
        if(idx==candidates.length) return;
        if(target==0){
            this.ret.add(new ArrayList<>(path));
            return;
        }
        this.traceBack(candidates, idx+1, target, path); // ignore cur
        if(target-candidates[idx]>=0){ // select cur
            List<Integer> pathCpy = new ArrayList<>(path);
            pathCpy.add(candidates[idx]);
            this.traceBack(candidates, idx, target-candidates[idx], pathCpy);
        }
    }
}
// @lc code=end

