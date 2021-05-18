package leetcode.editor.cn;

//给定两个字符串 s 和 t，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
// 示例 1:
//
//
//输入：s = "egg", t = "add"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "foo", t = "bar"
//输出：false
//
// 示例 3：
//
//
//输入：s = "paper", t = "title"
//输出：true
//
//
//
// 提示：
//
//
// 可以假设 s 和 t 长度相同。
//
// Related Topics 哈希表
// 👍 345 👎 0

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        // solution.isIsomorphic("badc", "baba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            // 主要就是非首次出现的
            HashMap<Character, Character> s2t = new HashMap<>();
            HashMap<Character, Character> t2s = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                if ((s2t.containsKey(sChar) && !s2t.get(sChar).equals(tChar))
                        || (t2s.containsKey(tChar) && !t2s.get(tChar).equals(sChar))) {
                    return false;
                }
                s2t.put(sChar, tChar);
                t2s.put(tChar, sChar);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
