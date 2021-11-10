/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    // 结果集
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        this.dfs(nums, used, new ArrayList<Integer>());
        return this.res;
    }
    
    private void dfs(int[] nums, boolean[] used, List<Integer> path){
        // base case
        if(path.size()==nums.length){
            // 收集
            this.res.add(new ArrayList<Integer>(path));
            return;
        }
        // 取未用过的数据
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                boolean[] newUsed = used.clone();
                newUsed[i]=true;
                int curNum = nums[i];
                List<Integer> newPath = new ArrayList<Integer>(path){{
                    add(curNum);
                }};
                this.dfs(nums, newUsed, newPath);
            }
        }
    }
}
// @lc code=end

