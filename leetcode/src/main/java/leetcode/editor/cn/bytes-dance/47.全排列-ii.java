/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int len=0;
        if(nums==null || (len=nums.length)==0) return ret;
        boolean[] visit = new boolean[len]; // all item is false
        Arrays.sort(nums); // asc
        this.dfs(nums, 0, visit, new ArrayList<>(), ret);
        return ret;
    }

    private void dfs(int[] nums, int idx, boolean[] visit, List<Integer> path, List<List<Integer>> ret){
        if(idx==nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visit[i] || (i>0 && !visit[i-1] && nums[i]==nums[i-1])) continue;
            boolean[] visitCpy = visit.clone();
            visitCpy[i]=true;
            List<Integer> pathCpy = new ArrayList<>(path);
            pathCpy.add(nums[i]);
            this.dfs(nums, idx+1, visitCpy, pathCpy, ret);
            
        }
    }
}
// @lc code=end

