import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-07 16:08:13
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 16:28:25
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1408 lang=java
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];
            sb.append(curWord);
            sb.append("#");
        }
        String source = sb.toString();
        for (String word : words) {
            if (source.indexOf(word) != source.lastIndexOf(word)) {
                // 出现了多次 word是别的单词的子串
                res.add(word);
            }
        }
        return res;
    }
}
// @lc code=end
