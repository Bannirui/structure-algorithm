package leetcode.editor.cn;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
// 👍 363 👎 0

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s != null && t != null) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                }
                for (int i = 0; i < t.length(); i++) {
                    if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) {
                        return false;
                    }
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
                // 判断value是不是都等于0
                return map.values().stream().mapToDouble(Integer::intValue).sum() == 0;
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
