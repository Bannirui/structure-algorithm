/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        return this.dfs(s, 0, s.length() - 1, k);
    }

    // s[start...end]每个字符至少出现cnt次的最长子串
    private int dfs(String s, int start, int end, int cnt) {
        // 每个字符的出现次数>=cnt 找出<cnt的作为临界 减少规模
        int[] cntArr = new int[26];
        for (int i = start; i <= end; i++) {
            cntArr[s.charAt(i) - 'a']++;
        }
        // 分割字符
        char partition = 0;
        for (int i = 0; i < 26; i++) {
            if (cntArr[i] != 0 && cntArr[i] < cnt) {
                // 找到了首个分割位置
                partition = (char) (i + 'a');
                break;
            }
        }
        if (partition == 0) {
            // s[start...end]没有分割字符
            return end - start + 1;
        } else {
            int i = start;
            int res = 0;
            while (i <= end) {
                // 跳过所有的parition字符
                while (i <= end && s.charAt(i) == partition) {
                    i++;
                }
                // 可能[start...end]都是不满足出现次数的字符
                if (i > end) {
                    break;
                }
                // [start...end]分割出来的子串
                int l = i;
                while (i <= end && s.charAt(i) != partition) {
                    i++;
                }
                int subLen = this.dfs(s, l, i - 1, cnt);
                res = Math.max(res, subLen);
            }
            return res;
        }
    }
}
// @lc code=end
