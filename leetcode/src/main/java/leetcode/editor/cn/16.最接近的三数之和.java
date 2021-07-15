import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-15 15:08:54
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-15 15:31:31
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // [b] [c]
            int b = a + 1, c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                // 刚好等于target
                if (sum == target) {
                    return sum;
                }
                // 不相等 记录绝对值并更新
                if (Math.abs(sum - target) < minGap) {
                    minGap = Math.abs(sum - target);
                    res = sum;
                }
                // 移动指针
                if (sum > target) {
                    c--;
                }
                if (sum < target) {
                    b++;
                }
            }
        }
        return res;
    }
}
// @lc code=end
