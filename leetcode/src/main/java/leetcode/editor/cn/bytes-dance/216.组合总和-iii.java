/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k<0 || n<0) throw new IllegalArgumentException();
        if(k==0 && n==0) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        this.backtrace(n,k,1,0,new ArrayList<>(), ret);
        return ret;
    }

    // [1...9]
    private void backtrace(int targetSum, int targetCnt, int num, int sum, List<Integer> path, List<List<Integer>> ret){
        if(sum==targetSum && path.size()==targetCnt){
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        if(num==10 || sum>targetSum || path.size()>targetCnt) return;
        this.backtrace(targetSum, targetCnt, num+1, sum, path, ret);
        List<Integer> pathCpy = new ArrayList<Integer>(path);
        pathCpy.add(num);
        this.backtrace(targetSum, targetCnt, num+1, sum+num, pathCpy, ret);
    }
}
// @lc code=end

