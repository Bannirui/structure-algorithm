/*
 * @Author: dingrui
 * @Date: 2021-07-01 13:33:38
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 13:50:27
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 子串
        int len1 = str1.length();
        int len2 = str2.length();
        for (int len = Math.min(len1, len2); len > 0; len--) {
            // 子串长度
            if (len1 % len == 0 && len2 % len == 0) {
                String sub = str1.substring(0, len);
                if (this.isSub(sub, str1) && this.isSub(sub, str2)) {
                    return sub;
                }
            }
        }
        return "";
    }

    /**
     * sub是否是parent的子串
     * @param sub
     * @param parent
     * @return
     */
    private boolean isSub(String sub, String parent) {
        int loop = parent.length() / sub.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            sb.append(sub);
        }
        return sb.toString().equals(parent);
    }
}
// @lc code=end
