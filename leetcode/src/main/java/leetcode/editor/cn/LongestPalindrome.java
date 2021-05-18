package leetcode.editor.cn;

//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
// 注意:
//假设字符串的长度不会超过 1010。
//
// 示例 1:
//
//
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
//
// Related Topics 哈希表
// 👍 283 👎 0

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        // solution.longestPalindrome("abccccdd");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            HashMap<Character, Integer> mapCount = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                mapCount.put(s.charAt(i), mapCount.getOrDefault(s.charAt(i), 0) + 1);
            }
            boolean allEven = true; // 没有奇数个字符
            int length = 0;
            for (Map.Entry<Character, Integer> entry : mapCount.entrySet()) {
                if (!isEven(entry.getValue())) { // 奇数
                    length += (entry.getValue() - 1);
                    allEven = false;
                } else {
                    length += entry.getValue();
                }
            }
            return !allEven ? length + 1 : length;
        }

        private boolean isEven(int num) { // 判断是否是偶数 true表示偶数
            return num % 2 == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
