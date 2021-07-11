/*
 * @Author: dingrui
 * @Date: 2021-07-11 16:42:08
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-11 16:49:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1684 lang=java
 *
 * [1684] 统计一致字符串的数目
 */

// @lc code=start
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] cache = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            char cur = allowed.charAt(i);
            int index = (int) (cur - 'a');
            if (!cache[index]) {
                cache[index] = true;
            }
        }
        int res = 0;
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (cache[word.charAt(j) - 'a']) {
                    if (j == word.length() - 1) {
                        res++;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end
