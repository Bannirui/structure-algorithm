import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-07 13:40:57
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 13:59:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
    public String sortString(String s) {
        // help[0...25]对应a...z的可用数量
        int[] help = new int[26];
        for (int i = 0; i < s.length(); i++) {
            help[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        // 字符总数
        int totalChar = s.length();
        while (totalChar != 0) {
            // 从小到大 从大到小
            int lastSmallIndex = -1;
            for (int small = 0; small < 26; small++) {
                if (small > lastSmallIndex && help[small] > 0) {
                    // 可取
                    sb.append((char) (small + 'a'));
                    lastSmallIndex = small;
                    help[small]--;
                    totalChar--;
                }
            }
            int lastLargeIndex = 26;
            for (int large = 25; large >= 0; large--) {
                if (large < lastLargeIndex && help[large] > 0) {
                    // 可取
                    sb.append((char) (large + 'a'));
                    lastLargeIndex = large;
                    help[large]--;
                    totalChar--;
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end
