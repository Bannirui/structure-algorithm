import java.util.Arrays;

/*
 * @Author: dingRui
 * @Date: 2021-08-03 15:41:46
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-03 16:14:02
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
        int h = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }
}
// @lc code=end
