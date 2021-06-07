package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3712 👎 0

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // solution.longestPalindrome("aaaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            // 回文字串s[L,R] 二维表dp[L,R]表示s[L,R]是不是回文
            // 初始化二维表 全是false
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            int maxLength = 0;
            int start = 0;
            int end = 0;
            // 填表
            // L
            for (int L = length - 1; L >= 0; L--) {
                // 左下->右上 斜线推
                for (int len = 1; len <= length; len++) {
                    // R
                    int R = L + len - 1;
                    // 1，L>R 不存在这种情况 填false 初始化的时候已经全部填false 这种情况不需要单独处理
                    // 2，L==R的时候只有一个字符 肯定是回文 L-R+1=1
                    // 3，子串长度为2或者3的时候 s[L]==s[R]就是回文
                    // 4，字串长度>=4 普遍的解 当前解=子问题的解
                    if (L == R) {
                        dp[L][R] = true;
                    }
                    if (R >= length) {
                        // 越界
                        break;
                    }
                    if (R > L && s.charAt(R) == s.charAt(L)) {
                        if (R - L + 1 <= 3) {
                            dp[L][R] = true;
                        }
                        if (R >= 1 && R - L + 1 > 3) {
                            dp[L][R] = dp[L + 1][R - 1];
                        }
                    }

                    // 维护最大值
                    if (dp[L][R]) {
                        if (R - L + 1 > maxLength) {
                            maxLength = R - L + 1;
                            start = L;
                            end = R;
                        }
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
