import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-07 15:18:27
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 15:26:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1394 lang=java
 *
 * [1394] 找出数组中的幸运数
 */

// @lc code=start
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int lastLuckyNum = Integer.MIN_VALUE;
        boolean findLuckyNum = false;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int curNum = entry.getKey();
            int curNumCounts = entry.getValue();
            if (curNum == curNumCounts) {
                findLuckyNum = true;
                lastLuckyNum = Math.max(lastLuckyNum, curNum);
            }
        }
        return findLuckyNum ? lastLuckyNum : -1;
    }
}
// @lc code=end
