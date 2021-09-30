import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        // base case
        int len = 0;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        // 固定的映射 最有两个罗马字符映射一个数字
        Map<String, Integer> map = new HashMap<>(13);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            // 先尝试匹配2个连续字符
            int cur = 0;
            if (i + 1 < len && (cur = map.getOrDefault(s.substring(i, i + 2), 0)) != 0) {
                sum += cur;
                i++;
            } else {
                cur = map.getOrDefault(s.substring(i, i + 1), 0);
                sum += cur;
            }
        }
        return sum;
    }
}
// @lc code=end
