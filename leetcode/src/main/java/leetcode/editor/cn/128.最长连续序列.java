import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        // 参数校验
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        // 以i开头的连续序列 [i...]
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (set.contains(curNum - 1)) {
                continue;
            } else {
                // 找到了i开头的
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                // 更新连续序列的长度
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
// @lc code=end
