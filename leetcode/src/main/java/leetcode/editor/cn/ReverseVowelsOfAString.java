package leetcode.editor.cn;

//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//
//
// 示例 1：
//
// 输入："hello"
//输出："holle"
//
//
// 示例 2：
//
// 输入："leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 元音字母不包含字母 "y" 。
//
// Related Topics 双指针 字符串
// 👍 149 👎 0

import java.util.HashSet;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        solution.reverseVowels("hello");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            // 双指针
            HashSet<Character> set = new HashSet<>(8);
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            set.add('A');
            set.add('E');
            set.add('I');
            set.add('O');
            set.add('U');
            char[] chars = new char[s.length()];
            int start = 0;
            int end = s.length() - 1;
            while (start <= end) {
                char cStart = s.charAt(start);
                char cEnd = s.charAt(end);
                if (set.contains(cStart)) {
                    if (set.contains(cEnd)) {
                        chars[start++] = cEnd;
                        chars[end--] = cStart;
                    } else {
                        chars[end--] = cEnd;
                    }
                } else {
                    chars[start++] = cStart;
                }
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
