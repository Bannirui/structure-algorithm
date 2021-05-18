package leetcode.editor.cn;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 727 👎 0

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // nums1是输出数组 有序数组 从小到大 最大放到最后
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;
            while (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[p] = nums1[p1];
                    p1--;
                } else {
                    nums1[p] = nums2[p2];
                    p2--;
                }
                p--;
            }
            // m跟n一定有一个先小于导致跳出while循环 如果是nums2先走完没事 如果是nums1先走完那就要把nums2的元素再拷贝过来 nums2剩下的元素一定是最小的
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}