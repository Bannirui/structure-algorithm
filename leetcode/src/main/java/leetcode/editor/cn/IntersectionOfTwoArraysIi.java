package leetcode.editor.cn;

//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 468 👎 0

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        // int[] ints1 = new int[4];
        // ints1[0] = 1;
        // ints1[1] = 2;
        // ints1[2] = 2;
        // ints1[3] = 1;
        // int[] ints2 = new int[2];
        // ints2[0] = 2;
        // ints2[1] = 2;
        // solution.intersect(ints1, ints2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums2.length < nums1.length) {
                return intersect(nums2, nums1);
            }
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums1) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            int[] res = new int[nums1.length];
            int index = 0;
            for (int item : nums2) {
                Integer count = countMap.getOrDefault(item, 0);
                if (count > 0) {
                    // item元素在两个原始数组中都存在 交集之一
                    res[index++] = item;
                    count--;
                    if (count > 0) {
                        // 更新map中元素的次数计数
                        countMap.put(item, count);
                    } else {
                        // 移除
                        countMap.remove(item);
                    }
                }
            }
            return Arrays.copyOf(res, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
