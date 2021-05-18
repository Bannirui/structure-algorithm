package leetcode.editor.cn;

//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
//
//
//
// 示例 1：
//
//
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。
//
// 示例 2：
//
//
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
//
//
// 示例 3：
//
//
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
//
//
//
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
// Related Topics 数组
// 👍 215 👎 0

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        // int[] ints = new int[4];
        // ints[0] = 2;
        // ints[1] = 2;
        // ints[2] = 3;
        // ints[3] = 1;
        // solution.thirdMax(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            quick(nums, 0, nums.length - 1);
            int i = 0;
            int count = 1;
            while (i < nums.length && count != 3) {
                if (i == 0) {
                    i++;
                    continue;
                }
                if (nums[i] != nums[i - 1]) {
                    count++;
                }
                i++;
            }
            return count == 3 ? nums[i] : nums[0];
        }

        private void quick(int[] arr, int left, int right) { // 快排
            if (left > right) {
                return;
            }
            int low = left;
            int high = right;
            int base = arr[low];
            while (low < high) {
                // 右边都是比基数小
                while (low < high && arr[high] <= base) {
                    high--;
                }
                arr[low] = arr[high];
                // 左边都是比基数小的
                while (low < high && arr[low] > base) {
                    low++;
                }
                arr[high] = arr[low];
            }
            // 一轮遍历结束 找到了base的脚标
            arr[low] = base;
            quick(arr, left, low - 1);
            quick(arr, low + 1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
