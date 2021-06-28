/*
 * @Author: dingrui
 * @Date: 2021-06-28 17:04:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 17:36:28
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String s, String goal) {
        // 两个串长度不同
        if (s == null || goal == null || s.length() == 0 || s.length() != goal.length()) {
            return false;
        }
        /**
         * 两个串长度相同
         *   两个串不同
         *     只有两个位置的字符不同
         *       并且可以交换
         *       交叉位不同
         *     多个位置不同
         *   两个串相同
         *     全是同一个字符
         *     不同字符
         */
        if (s.equals(goal)) {
            // 两个串相同
            int[] sCharCount = new int[26];
            for (int i = 0; i < s.length(); i++) {
                sCharCount[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (sCharCount[i] > 1) {
                    // 至少出现aa...这样的才能交换出来结果
                    return true;
                }
            }
            return false;
        } else {
            // 两个串不同
            int firDiffIndex = -1, secDiffIndex = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    // 出现了字符不同的位置
                    if (firDiffIndex != -1 && secDiffIndex != -1) {
                        // 出现了第二对字符不同的位置
                        return false;
                    }
                    if (firDiffIndex == -1) {
                        firDiffIndex = i;
                    } else {
                        secDiffIndex = i;
                    }
                }
            }
            if (firDiffIndex != -1 && secDiffIndex != -1) {
                // 交叉位比较
                if (s.charAt(firDiffIndex) == goal.charAt(secDiffIndex)
                        && s.charAt(secDiffIndex) == goal.charAt(firDiffIndex)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
// @lc code=end
