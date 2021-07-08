/*
 * @Author: dingrui
 * @Date: 2021-07-08 13:29:43
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 13:35:37
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1455 lang=java
 *
 * [1455] 检查单词是否为句中其他单词的前缀
 */

// @lc code=start
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (this.isPrefix(searchWord, words[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    // sub是parent的前缀返回true
    private boolean isPrefix(String sub, String parent) {
        if (sub == null || parent == null) {
            return false;
        }
        if (sub.length() > parent.length()) {
            return false;
        }
        int i = 0;
        while (i < sub.length()) {
            if (sub.charAt(i) != parent.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
// @lc code=end
