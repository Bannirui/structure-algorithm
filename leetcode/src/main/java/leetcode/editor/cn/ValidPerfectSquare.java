package leetcode.editor.cn;

//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。
//
//
//
// 示例 1：
//
//
//输入：num = 16
//输出：true
//
//
// 示例 2：
//
//
//输入：num = 14
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= num <= 2^31 - 1
//
// Related Topics 数学 二分查找
// 👍 205 👎 0

public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        // solution.isPerfectSquare(14);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            long start = 0;
            long end = num;
            while (start <= end) {
                long mid = start + ((end - start) >> 1);
                long res = -1;
                if ((res = (mid * mid)) == num) {
                    return true;
                } else if (res > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
