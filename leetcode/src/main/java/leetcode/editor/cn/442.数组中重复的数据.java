import java.util.Set;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // base case
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return Collections.EMPTY_LIST;
        }
        // 索引index跟索引上值value的关系->index+1=value
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < len; i++) {
            // 当前索引index 值value
            int value = nums[i];
            if (value - 1 == i) {
                // 已经处理好 pass
                continue;
            } else {
                if (nums[value - 1] == value) {
                    // 当前的value重复了
                    res.add(value);
                } else {
                    // 把当前value放到合理的位置上去
                    nums[i] = nums[value - 1];
                    nums[value - 1] = value;
                    if (i < value - 1) {
                        i--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
// @lc code=end
