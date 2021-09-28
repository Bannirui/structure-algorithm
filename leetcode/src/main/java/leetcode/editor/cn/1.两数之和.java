/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // base case
        int len = 0;
        int[] invalidRes = new int[] { -1, -1 };
        if (nums == null || (len = nums.length) == 0) {
            return invalidRes;
        }
        // map key=value val=index
        Map<Integer, Integer> val2IdxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            val2IdxMap.put(nums[i], i);
        }
        // 匹配
        for (int i = 0; i < len; i++) {
            int nextValIdx = -1;
            if ((nextValIdx = val2IdxMap.getOrDefault(target - nums[i], -1)) != -1 && i != nextValIdx) {
                return new int[] { i, nextValIdx };
            }
        }
        return invalidRes;
    }
}
// @lc code=end
