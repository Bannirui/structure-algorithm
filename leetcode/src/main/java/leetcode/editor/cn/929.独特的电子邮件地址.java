import java.util.HashSet;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-06-29 14:17:26
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 14:52:39
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=929 lang=java
 *
 * [929] 独特的电子邮件地址
 */

// @lc code=start
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for (String email : emails) {
            String[] emailSplit = email.split("@");
            String local = emailSplit[0];
            String remote = emailSplit[1];
            // 处理+ .
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            local = local.replaceAll("\\.", "");
            res.add(local + "@" + remote);
        }
        return res.size();
    }
}
// @lc code=end
