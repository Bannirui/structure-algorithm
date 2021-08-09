/*
 * @Author: dingRui
 * @Date: 2021-08-06 17:23:28
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-09 10:48:07
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        // 遍历单词
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 两个单词是否存在公共字母
                if (this.noCommonLetter(words[i], words[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private boolean noCommonLetter(String s1, String s2) {
        int mask1 = this.maskString(s1);
        int mask2 = this.maskString(s2);
        return (mask1 & mask2) == 0;
    }

    private int maskString(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            mask |= 1 << (int) (c - 'a');
        }
        return mask;
    }
}
// @lc code=end
