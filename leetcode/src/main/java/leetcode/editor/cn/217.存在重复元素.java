import java.util.Map;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 存储num以及对应出现的次数
        Map<Integer, Integer> cntMap = new HashMap<>();
        // 遍历所有的元素
        for (int num : nums) {
            // 已经出现的次数
            Integer curCnt = cntMap.getOrDefault(num, 0);
            if (curCnt >= 1) {
                return true;
            }
            cntMap.put(num, curCnt + 1);
        }
        return false;
    }
}
// @lc code=end
