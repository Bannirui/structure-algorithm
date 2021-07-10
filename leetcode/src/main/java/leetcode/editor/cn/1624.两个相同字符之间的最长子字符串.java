import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-10 15:47:09
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 15:51:13
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1624 lang=java
 *
 * [1624] 两个相同字符之间的最长子字符串
 */

// @lc code=start
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        // key=char value=下标
        Map<Character, Integer> indexMap = new HashMap<>();
        int len = 0;
        boolean existsPair = false;
        for (int i = 0; i < s.length(); i++) {
            if (indexMap.containsKey(s.charAt(i))) {
                len = Math.max(len, i - indexMap.get(s.charAt(i)) - 1);
                // 存在一对字符
                existsPair = true;
            } else {
                indexMap.put(s.charAt(i), i);
            }
        }
        return existsPair ? len : -1;
    }
}
// @lc code=end
