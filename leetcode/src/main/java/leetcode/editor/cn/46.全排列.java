/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // trace
        boolean[] used = new boolean[nums.length];
        this.trace(nums, used, new ArrayList<Integer>());
        return this.res;
    }

    // 回溯
    // 已经存在数组path 从nums的还没使用过的元素中 继续挑选 组合新的列表
    private void trace(int[] nums, boolean[] used, List<Integer> path){
        // base case
        if(path.size()==nums.length){
            this.res.add(new ArrayList<>(path));
            return;
        }
        // 遍历可使用的元素
        for(int i=0;i<used.length;i++){
            if(!used[i]){
                // 可以使用该数字 可以选择使用或者不使用
                // 使用
                boolean[] used4Select = used.clone();
                used4Select[i]=true;
                List<Integer> path4Select = new ArrayList<>(path);
                path4Select.add(nums[i]);
                this.trace(nums, used4Select, path4Select);
            }
        }
    }


}
// @lc code=end

