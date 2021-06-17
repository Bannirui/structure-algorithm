import java.util.Arrays;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = score[i];
        }
        Arrays.sort(tmp);
        // 哈希表 成绩-名次
        Map<Integer, String> map = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                map.put(tmp[i], "Gold Medal");
            } else if (i == len - 2) {
                map.put(tmp[i], "Silver Medal");
            } else if (i == len - 3) {
                map.put(tmp[i], "Bronze Medal");
            } else {
                map.put(tmp[i], "" + (len - i));
            }
        }

        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            res[i] = map.get(score[i]);
        }
        return res;
    }
}
// @lc code=end
