import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @Author: dingrui
 * @Date: 2021-07-20 18:23:48
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-20 18:41:16
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String orderStr = this.orderChar(str);
            List<String> strList = map.getOrDefault(orderStr, new ArrayList<String>());
            strList.add(str);
            map.put(orderStr, strList);
        }
        return map.entrySet().stream().map(o -> o.getValue()).collect(Collectors.toList());
    }

    // 字符串中字符排序后返回
    private String orderChar(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
// @lc code=end
