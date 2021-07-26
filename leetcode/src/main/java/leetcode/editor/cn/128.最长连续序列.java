import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-26 07:17:24
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-26 09:42:34
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 元素全部放到集合
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // [...num]
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                // 继续
            } else {
                int curNum = nums[i];
                int curStreak = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curStreak++;
                }
                res = Math.max(curStreak, res);
            }
        }
        return res;
    }
}
// @lc code=end
