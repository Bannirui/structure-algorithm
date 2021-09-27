import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListSet;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = 0, lenP = 0;
        List<Integer> res = new ArrayList<>();
        if (s == null || (lenS = s.length()) == 0 || p == null || (lenP = p.length()) == 0 || lenS < lenP) {
            return res;
        }
        // 窗口内字符数量统计
        int[] countS = new int[26];
        int[] countP = new int[26];
        // 第一个窗口 起始脚标0
        for (int i = 0; i < lenP; i++) {
            countS[s.charAt(i) - 'a']++;
            countP[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(countS, countP)) {
            res.add(0);
        }
        // 窗口的右边界[m...n]
        for (int i = lenP; i < lenS; i++) {
            // 更新滑动窗口
            countS[s.charAt(i - lenP) - 'a']--;
            countS[s.charAt(i) - 'a']++;
            if (Arrays.equals(countS, countP)) {
                res.add(i - lenP + 1);
            }
        }
        return res;
    }
}
// @lc code=end
