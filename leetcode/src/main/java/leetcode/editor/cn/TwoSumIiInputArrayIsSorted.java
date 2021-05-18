package leetcode.editor.cn;

//给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。
//
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//
//
// 示例 1：
//
//
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
//
//
// 示例 2：
//
//
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//
//
// 示例 3：
//
//
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 2 <= numbers.length <= 3 * 104
// -1000 <= numbers[i] <= 1000
// numbers 按 递增顺序 排列
// -1000 <= target <= 1000
// 仅存在一个有效答案
//
// Related Topics 数组 双指针 二分查找
// 👍 486 👎 0

public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();

        // int[] numbers = {2, 3, 4};
        // int tartget = 6;
        // int[] ints = solution.twoSum(numbers, tartget);
        // System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                if (i == numbers.length - 1) {
                    return null;
                }
                int dest = bst(numbers, target - numbers[i], i + 1, numbers.length - 1);
                if (dest != -1) {
                    return new int[]{i + 1, dest + 1};
                }
            }
            return null;
        }

        /**
         * @author dingrui
         * @date 2021/3/12
         * @param nums
         * @param num
         * @return
         * @description 二分查找 返回脚标 -1表示没找到
         */
        public int bst(int[] nums, int num, int start, int end) {
            while (start <= end) {
                int mid = start + ((end - start) >>> 1);
                if (nums[mid] == num) {
                    // 找到了
                    return mid;
                }
                if (nums[mid] < num) {
                    // 目标值在数组右边
                    start = mid + 1;
                } else {
                    // 目标值在数组左边
                    end = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
