import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-23 17:16:49
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-26 13:44:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // 暴力
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
// @lc code=end
