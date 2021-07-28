import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-28 17:25:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-28 17:51:55
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return Collections.emptyList();
        }
        Set<String> countMap = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (countMap.contains(sub)) {
                res.add(sub);
            } else {
                countMap.add(sub);
            }
        }
        return new ArrayList<>(res);
    }
}
// @lc code=end
