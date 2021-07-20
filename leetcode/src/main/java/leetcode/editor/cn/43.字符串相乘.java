import java.util.Objects;

/*
 * @Author: dingrui
 * @Date: 2021-07-19 21:15:52
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-20 11:49:23
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        // 参数检查
        if (Objects.equals("0", num1) || Objects.equals("0", num2)) {
            return "0";
        }
        // 结果
        String res = "0";
        // num2各位
        for (int i = num2.length() - 1; i >= 0; i--) {
            // num2[i] * num1
            StringBuilder sb = new StringBuilder();
            // num2[i] 在10位->结果末尾补1个0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append(0);
            }
            int carry = 0;
            for (int l = num1.length() - 1; l >= 0 || carry != 0; l--) {
                int n1 = l < 0 ? 0 : num1.charAt(l) - '0';
                int n2 = num2.charAt(i) - '0';
                int product = n1 * n2 + carry;
                int left = product % 10;
                carry = product / 10;
                sb.append(left);
            }
            res = this.stringAdd(res, sb.reverse().toString());
        }
        return res;
    }

    // 字符串形式 求和
    private String stringAdd(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = s1.length() - 1, j = s2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int n1 = i < 0 ? 0 : s1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : s2.charAt(j) - '0';
            int sum = n1 + n2 + carry;
            int left = sum % 10;
            carry = sum / 10;
            sb.append(left);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end
