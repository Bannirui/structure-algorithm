import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-06-21 13:20:49
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 16:30:28
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution {
    public int findLHS(int[] nums) {
        int res = 0;
        int len = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (countMap.containsKey(entry.getKey() + 1)) {
                res = Math.max(res, entry.getValue() + countMap.get(entry.getKey() + 1));
            }
        }
        return res;
    }
}
// @lc code=end
