package leetcode.editor.cn;

//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
//
// 示例:
//
// 输入: 38
//输出: 2
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
//
//
// 进阶:
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
// Related Topics 数学
// 👍 324 👎 0

public class AddDigits {
    public static void main(String[] args) {
        Solution solution = new AddDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addDigits(int num) {
            // 非负数 反复 各位相加 1位数
            if (num < 10) {
                return num;
            }
            // 各个位相加
            int i = subSum(num, 0);
            return addDigits(i);
        }

        private int subSum(int num, int res) {
            if (num < 10) {
                return res + num;
            }
            res += num % 10;
            return subSum(num / 10, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
