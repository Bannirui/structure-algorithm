import java.util.Map;

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
        if (nums == null || (len = nums.length) == 0) {
            return new int[] { -1, -1 };
        }
        // value-index
        Map<Integer, Integer> value2IndexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            value2IndexMap.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            Integer nextIdx = null;
            if ((nextIdx = value2IndexMap.getOrDefault(target - nums[i], null)) != null && i != nextIdx.intValue()) {
                return new int[] { i, nextIdx };
            }
        }
        // 没有答案
        return new int[] { -1, -1 };
    }
}
// @lc code=end
