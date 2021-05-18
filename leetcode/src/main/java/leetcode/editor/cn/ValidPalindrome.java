package leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 325 👎 0

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            // 字母和数字
            if (s == null) {
                return false;
            }
            // 空字符串
            if (s.trim().isEmpty()) {
                return true;
            }
            // 正常字符串
            s = s.toLowerCase();
            int left = 0;
            int right = s.length() - 1;
            while (right - left >= 1) {
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                    continue;
                }
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}