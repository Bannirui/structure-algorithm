import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-07 15:40:04
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 16:06:29
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1403 lang=java
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // nums升序
        Arrays.sort(nums);
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int l = nums.length - 1, r = nums.length - 1;
        int windowSum = nums[nums.length - 1];
        while (l >= 0) {
            if (windowSum > (totalSum - windowSum)) {
                // 找到目标值
                for (int k = r; k >= l; k--) {
                    res.add(nums[k]);
                }
                break;
            } else {
                // 继续左扩
                l--;
                windowSum += nums[l];
            }
        }
        return res;
    }
}
// @lc code=end
