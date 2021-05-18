package leetcode.editor.cn;

//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例 1：
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
//
//
// 示例 2：
//
// 输入：s = "", t = "y"
//输出："y"
//
//
// 示例 3：
//
// 输入：s = "a", t = "aa"
//输出："a"
//
//
// 示例 4：
//
// 输入：s = "ae", t = "aea"
//输出："a"
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
//
// Related Topics 位运算 哈希表
// 👍 241 👎 0

import java.util.HashMap;

public class FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            // t在s重排基础上添加了一个字母 找出来
            if (s.length() == 0) {
                return t.charAt(0);
            }
            HashMap<Character, Integer> countMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int j = 0; j < t.length(); j++) {
                Integer count = countMap.getOrDefault(t.charAt(j), 0);
                if (count == 0) {
                    return t.charAt(j);
                }
                count--;
                if (count > 0) {
                    countMap.put(t.charAt(j), count);
                } else {
                    countMap.remove(t.charAt(j));
                }
            }
            return ((char) 'a');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
