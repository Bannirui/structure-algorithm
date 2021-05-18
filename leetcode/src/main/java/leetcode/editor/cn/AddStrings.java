package leetcode.editor.cn;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//
//
// 提示：
//
//
// num1 和num2 的长度都小于 5100
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
//
// Related Topics 字符串
// 👍 357 👎 0

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        // String s = solution.addStrings("123", "11");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int num1Length = num1.length();
            int num2Length = num2.length();
            int i = num1Length - 1;
            int j = num2Length - 1;
            int carry = 0;
            StringBuffer sb = new StringBuffer();
            while (i >= 0 || j >= 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int tmp = x + y + carry;
                // 结果
                sb.append(tmp % 10);
                // 新的进位
                carry = tmp / 10;
                i--;
                j--;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
