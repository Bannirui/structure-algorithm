import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-06-23 11:27:28
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-26 00:06:11
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // int[] 0->count 1->first index 2->last index
            if (countMap.containsKey(nums[i])) {
                int[] oldInfo = countMap.get(nums[i]);
                int[] newInfo = new int[] { oldInfo[0] + 1, oldInfo[1], i };
                countMap.put(nums[i], newInfo);
            } else {
                countMap.put(nums[i], new int[] { 1, i, i });
            }
        }
        int maxCount = Integer.MIN_VALUE;
        int res = 0;
        for (Map.Entry<Integer, int[]> entry : countMap.entrySet()) {
            int[] info = entry.getValue();
            int count = info[0];
            int firstIndex = info[1];
            int lastIndex = info[2];
            if (count > maxCount) {
                maxCount = count;
                res = lastIndex - firstIndex + 1;
            } else if (count == maxCount) {
                res = Math.min(res, lastIndex - firstIndex + 1);
            }
        }
        return res;
    }
}
// @lc code=end
