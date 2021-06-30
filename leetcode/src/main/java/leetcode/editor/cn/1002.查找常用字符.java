import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-30 14:06:29
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 14:17:46
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] words) {
        // mark[i][j] 第'a'+j字符在words第j个word中出现的次数
        int[][] mark = new int[26][words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                mark[c - 'a'][i]++;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            // 在n个单词中出现的次数
            int[] row = mark[i];
            Arrays.sort(row);
            // 字符出现的最小次数
            int countMin = row[0];
            for (int j = 0; j < countMin; j++) {
                char c = (char) ('a' + i);
                res.add("" + c);
            }
        }
        return res;
    }
}
// @lc code=end
