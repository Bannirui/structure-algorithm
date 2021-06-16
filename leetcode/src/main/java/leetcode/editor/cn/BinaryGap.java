package leetcode.editor.cn;

//给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
//
// 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"100
//1" 中的两个 1 的距离为 3 。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 22
//输出：2
//解释：
//22 的二进制是 "10110" 。
//在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
//第一对相邻的 1 中，两个 1 之间的距离为 2 。
//第二对相邻的 1 中，两个 1 之间的距离为 1 。
//答案取两个距离之中最大的，也就是 2 。
//
//
// 示例 2：
//
//
//输入：n = 5
//输出：2
//解释：
//5 的二进制是 "101" 。
//
//
// 示例 3：
//
//
//输入：n = 6
//输出：1
//解释：
//6 的二进制是 "110" 。
//
//
// 示例 4：
//
//
//输入：n = 8
//输出：0
//解释：
//8 的二进制是 "1000" 。
//在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
//
//
// 示例 5：
//
//
//输入：n = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= N <= 10^9
//
// Related Topics 数学
// 👍 66 👎 0

public class BinaryGap {
    public static void main(String[] args) {
        Solution solution = new BinaryGap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int binaryGap(int n) {
            // 依次遍历找到最低位是不是1 记下来
            int[] cache = new int[32];
            int index=0;
            for (int i = 0; i < 32; i++) {
                if (((n >>> i) & 1) != 0) {
                    // 第i位是1
                    cache[index] = i;
                    index++;
                }
            }
            int max = 0;
            for (int i = 1; i < 32; i++) {
                max = Math.max(max, cache[i] - cache[i - 1]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
