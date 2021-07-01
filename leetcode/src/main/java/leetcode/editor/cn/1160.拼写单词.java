/*
 * @Author: dingrui
 * @Date: 2021-07-01 17:26:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 17:40:57
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 */

// @lc code=start
class Solution {
    public int countCharacters(String[] words, String chars) {
        // 所有可以使用的字符表
        int[] help = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            help[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        // 以单词为粒度消费字符
        flag: for (String word : words) {
            // 需要消费的字符表
            int[] consumer = new int[26];
            for (int j = 0; j < word.length(); j++) {
                consumer[word.charAt(j) - 'a']++;
            }
            // 供需关系
            for (int k = 0; k < 26; k++) {
                if (help[k] < consumer[k]) {
                    continue flag;
                }
            }
            res += word.length();
        }
        return res;
    }
}
// @lc code=end
