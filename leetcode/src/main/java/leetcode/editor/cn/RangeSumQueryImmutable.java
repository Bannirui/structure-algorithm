// package leetcode.editor.cn;
//
// //给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
// //
// //
// //
// // 实现 NumArray 类：
// //
// //
// // NumArray(int[] nums) 使用数组 nums 初始化对象
// // int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 s
// //um(nums[i], nums[i + 1], ... , nums[j])）
// //
// //
// //
// //
// // 示例：
// //
// //
// //输入：
// //["NumArray", "sumRange", "sumRange", "sumRange"]
// //[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
// //输出：
// //[null, 1, -1, -3]
// //
// //解释：
// //NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
// //numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
// //numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
// //numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// //
// //
// //
// //
// // 提示：
// //
// //
// // 0 <= nums.length <= 104
// // -105 <= nums[i] <= 105
// // 0 <= i <= j < nums.length
// // 最多调用 104 次 sumRange 方法
// //
// //
// //
// // Related Topics 动态规划
// // 👍 318 👎 0
//
//
// public class RangeSumQueryImmutable {
//     public static void main(String[] args) {
//         Solution solution = new RangeSumQueryImmutable().new Solution();
//     }
//
//     //leetcode submit region begin(Prohibit modification and deletion)
//     class NumArray {
//         // dp[i][j]=dp[i][j-1]+nums[j]或者dp[i][j]=dp[i-1][j]+nums[i]
//         // private int[][] dp;
//
//         private int[] dp;
//
//         public NumArray(int[] nums) {
//             // int length = nums.length - 1;
//             // dp = new int[length][length]; // java默认初始化元素为0
//             // for (int j = 0; j < length; j++) {
//             //     // 初始化第一行
//             //     dp[0][j] = nums[j];
//             // }
//             // for (int i = 0; i < length; i++) {
//             //     for (int j = 0; j < length; j++) {
//             //         if (i == j) {
//             //             dp[i][j] = nums[i];
//             //         }
//             //         if (i < j) {
//             //             dp[i][j] = dp[i - 1][j] + nums[j];
//             //         }
//             //     }
//             // }
//
//             int length = nums.length;
//             dp = new int[length + 1];
//             for (int i = 0; i <= length; i++) {
//                 dp[i + 1] = dp[i] + nums[i];
//             }
//         }
//
//         public int sumRange(int left, int right) {
//             // return dp[left][right];
//             return dp[j + 1] - dp[i];
//         }
//     }
//
// /**
//  * Your NumArray object will be instantiated and called as such:
//  * NumArray obj = new NumArray(nums);
//  * int param_1 = obj.sumRange(left,right);
//  */
// //leetcode submit region end(Prohibit modification and deletion)
//
// }
