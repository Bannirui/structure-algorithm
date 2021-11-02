/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 不重复 x y z
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            // 跳过重复x
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            // 找到了不一样的x 在[i+1...]找不一样的y z
            // y+z=0-x
            int target = -nums[i];
            for(int j=i+1;j<nums.length;j++){
                // 跳过重复y
                if(j>i+1&&j<nums.length && nums[j]==nums[j-1]){
                    continue;
                }
                // 找到了不一样的y 在[j+1...]找z
                int k=nums.length-1;
                while(k>j && nums[j]+nums[k]>target){
                        // k减小 找更小的y+z
                        k--;
                }
                // k左移之后跟j重合了
                if(k==j){
                    continue;
                }
                if(nums[i]+nums[j]+nums[k]==0){
                    // 收集答案
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                }
            }

        }
        return res;
    }
}
// @lc code=end

