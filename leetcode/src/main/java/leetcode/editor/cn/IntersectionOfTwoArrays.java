package leetcode.editor.cn;

//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 346 👎 0

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int i : nums1) {
                set1.add(i);
            }
            for (int i : nums2) {
                set2.add(i);
            }
            return getSub(set1, set2);
        }

        private int[] getSub(Set<Integer> set1, Set<Integer> set2) {
            if (set1.size() > set2.size()) {
                return getSub(set2, set1);
            }
            // 遍历小的集合
            HashSet<Integer> sub = new HashSet<>();
            for (Integer num : set1) {
                if (set2.contains(num)) {
                    sub.add(num);
                }
            }
            int[] res = new int[sub.size()];
            int index = 0;
            for (Integer i : sub) {
                res[index++] = i;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
