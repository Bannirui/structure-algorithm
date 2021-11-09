/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key=num value=idx
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                // 存在两个数字之和=target
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        // 遍历结束
        return new int[]{-1, -1};
    }
}
// @lc code=end

