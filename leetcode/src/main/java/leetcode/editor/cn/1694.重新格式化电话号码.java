import org.omg.PortableServer.POAPackage.WrongPolicyHelper;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 10:00:34
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 10:28:57
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1694 lang=java
 *
 * [1694] 重新格式化电话号码
 */

// @lc code=start
class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        number = number.replaceAll("\\s+", "").replaceAll("-", "");
        int i = 0;
        while (i < number.length() - 4) {
            sb.append(number.substring(i, i + 3));
            sb.append("-");
            i += 3;
        }
        // 剩下4个 剩下3个 剩下2个
        if (number.length() - i == 4) {
            sb.append(number.substring(i, i + 2));
            sb.append("-");
            sb.append(number.substring(i + 2, i + 4));
        } else if (number.length() - i == 3) {
            sb.append(number.substring(i, i + 3));
        } else if (number.length() - i == 2) {
            sb.append(number.substring(i, i + 2));
        }
        return sb.toString();
    }
}
// @lc code=end
