import javax.swing.text.WrappedPlainView;

import org.omg.CORBA.WrongTransaction;

/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        // 双指针 先找不一样的 然后计数
        int slow = 0, fast = 1;
        // 写指针
        int writeIndex = 0;
        int len = chars.length;
        while (slow < len && writeIndex < len) {
            // 找到slow跟fast不一样字符的脚标
            while (fast < len && chars[slow] == chars[fast]) {
                fast++;
            }
            // 字符计数 计数=1的时候只写当前字符不写计数
            int count = fast - slow;
            chars[writeIndex++] = chars[slow];
            if (count > 1 && writeIndex < len) {
                // 写当前字符对应的计数
                StringBuilder sb = new StringBuilder();
                while (count > 0) {
                    int mod = count % 10;
                    count /= 10;
                    sb.append(mod);
                }
                String tmp = sb.reverse().toString();
                for (int i = 0; i < tmp.length(); i++) {
                    chars[writeIndex++] = tmp.charAt(i);
                }
            }
            // 慢指针来到快指针地方 快指针+1
            slow = fast;
            fast++;
        }
        return writeIndex;
    }
}
// @lc code=end
