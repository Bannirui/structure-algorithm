import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-09 13:53:11
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 14:22:56
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
class Solution {
    public String reorderSpaces(String text) {
        // 空格数量
        int spaceCounts = 0;
        // 单词
        List<String> words = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCounts++;
            } else {
                int j = i + 1;
                while (j < text.length() && text.charAt(j) != ' ') {
                    j++;
                }
                words.add(text.substring(i, j));
                i = j - 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (words.size() == 1) {
            // 只有一个单词
            sb.append(words.get(0));
            for (int i = 0; i < spaceCounts; i++) {
                // 空格全部加到末尾
                sb.append(' ');
            }
        } else {
            // 每两个单词之间 空格数量
            int spacesBetweenWords = spaceCounts / (words.size() - 1);
            // 追加末尾的空格
            int spacesLeft = spaceCounts % (words.size() - 1);
            for (int m = 0; m < words.size(); m++) {
                sb.append(words.get(m));
                if (m != (words.size() - 1)) {
                    for (int l = 0; l < spacesBetweenWords; l++) {
                        sb.append(' ');
                    }
                }
            }
            for (int k = 0; k < spacesLeft; k++) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
// @lc code=end
