package leetcode.editor.cn;

//给定一个整数数组，判断是否存在重复元素。
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//
//
//
// 示例 1:
//
//
//输入: [1,2,3,1]
//输出: true
//
// 示例 2:
//
//
//输入: [1,2,3,4]
//输出: false
//
// 示例 3:
//
//
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true
// Related Topics 数组 哈希表
// 👍 376 👎 0

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            // 元素 出现次数 映射关系
            // HashMap<Integer, Integer> map = new HashMap<>();
            // for (int num : nums) {
            //     if (map.getOrDefault(num, 0) + 1 >= 2) {
            //         return true;
            //     }
            //     map.put(num, map.getOrDefault(num, 0) + 1);
            // }
            // return false;

            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)){
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
