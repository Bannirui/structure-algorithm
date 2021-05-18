package leetcode.editor.cn;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 779 👎 0

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        // int i = solution.searchInsert(new int[]{1, 3, 5, 6}, 2);
        // System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            // 二分查找
            int left = 0;
            int right = nums.length - 1;
            int res = nums.length;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] >= target) {
                    // 缓存下mid对应的值 继续查找mid左边
                    res = mid;
                    right = mid - 1;
                } else {
                    // 查找右边
                    left = mid + 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}