import java.util.List;
import java.util.Objects;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 16:02:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 16:07:41
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1773 lang=java
 *
 * [1773] 统计匹配检索规则的物品数量
 */

// @lc code=start
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int index = 0;
        if (Objects.equals("type", ruleKey)) {
            index = 0;
        }
        if (Objects.equals("color", ruleKey)) {
            index = 1;
        }
        if (Objects.equals("name", ruleKey)) {
            index = 2;
        }
        for (List<String> item : items) {
            String value = item.get(index);
            if (Objects.equals(value, ruleValue)) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end
