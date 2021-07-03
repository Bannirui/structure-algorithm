import java.util.Map;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-03 14:52:13
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-03 15:00:11
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // count times
        Set<Integer> countSet = new HashSet<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (countSet.contains(entry.getValue())) {
                return false;
            }
            countSet.add(entry.getValue());
        }
        return true;
    }
}
// @lc code=end
