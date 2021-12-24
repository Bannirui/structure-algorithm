/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> val2IdxMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(val2IdxMap.containsKey(target-nums[i])){
                // hit
                return new int[]{i, val2IdxMap.get(target-nums[i])};
            }else{
                val2IdxMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

