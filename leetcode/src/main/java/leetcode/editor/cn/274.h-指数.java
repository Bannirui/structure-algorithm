/*
 * @Author: dingRui
 * @Date: 2021-08-03 15:41:46
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-03 16:07:11
 * @Descriptio:
 */
/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        // 二分
        int low = 0, high = citations.length;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            boolean check = this.check(citations, mid);
            if (check) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    private boolean check(int[] citations, int num) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= num) {
                count++;
            }
            if (count >= num) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
