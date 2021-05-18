package leetcode.editor.cn;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2781 👎 0

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int i = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            // 最大的和 是比较出来的 sum(i)表示i结尾的最大连续子数组的和 sum(n)=max(sum(n-1), n) 动态规划的话可以手动推演
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                // 以x这个元素结尾的子数组的最大的和
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}