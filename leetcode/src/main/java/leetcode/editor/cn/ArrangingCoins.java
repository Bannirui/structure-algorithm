package leetcode.editor.cn;

//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。
//
// n 是一个非负整数，并且在32位有符号整型的范围内。
//
// 示例 1:
//
//
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
//
//
// 示例 2:
//
//
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
//
// Related Topics 数学 二分查找
// 👍 101 👎 0

public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
        solution.arrangeCoins(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            if (n <= 0) {
                return 0;
            }
            long left = 1L;
            long right = n;
            while (left <= right) {
                long mid = left + ((right - left) >>> 1);
                long sum = sum(mid);
                if (sum == n) {
                    return (int) mid;
                }
                if (sum < n) {
                    // 往右继续找
                    left = mid + 1;
                } else {
                    // 往左继续
                    right = mid - 1;
                }
            }
            // 没有找到刚好等于的 就找最接近的
            return (int) right;
        }

        private long sum(long m) {
            return (1 + m) * m / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
