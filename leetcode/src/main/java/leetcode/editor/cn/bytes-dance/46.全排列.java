/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len=0;
        List<List<Integer>> ret = new ArrayList<>();
        if(nums==null || (len=nums.length)==0) return ret;
        // default value is false
        boolean[] visit = new boolean[len];
        this.dfs(nums, 0, visit, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void dfs(int[] nums, int idx, boolean[] visit, List<Integer> path, List<List<Integer>> ret){
        // base case
        if(idx==nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visit[i]){
                boolean[] visitCpy = visit.clone();
                visitCpy[i]=true;
                List<Integer> pathCpy = new ArrayList<>(path);
                pathCpy.add(nums[i]);
                this.dfs(nums, idx+1, visitCpy, pathCpy, ret);
            }
        }
    }
}
// @lc code=end

