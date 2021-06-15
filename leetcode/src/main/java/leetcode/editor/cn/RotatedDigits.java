package leetcode.editor.cn;

//我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
//
// 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况
//下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
//
// 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
//
//
//
// 示例：
//
// 输入: 10
//输出: 4
//解释:
//在[1, 10]中有四个好数： 2, 5, 6, 9。
//注意 1 和 10 不是好数, 因为他们在旋转之后不变。
//
//
//
//
// 提示：
//
//
// N 的取值范围是 [1, 10000]。
//
// Related Topics 字符串
// 👍 93 👎 0

public class RotatedDigits {
    public static void main(String[] args) {
        Solution solution = new RotatedDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rotatedDigits(int n) {
            /**
             * 1位
             *  0
             *  1
             *  2 √
             *  3 x
             *  4 x
             *  5 √
             *  6 √
             *  7 x
             *  8
             *  9 √
             *
             * 2位
             * 10 x
             * 11 x
             * 12 √
             * 13 x
             * 14 x
             * 15
             * 16
             * 17
             * 18
             * 19
             *
             * ...
             */
            // 从数字低位往高位判断 高位递归
            int res = 0;
            for (int x = 1; x <= n; x++) {
                if (goodNum(x, false)) {
                    res++;
                }
            }
            return res;
        }

        public boolean goodNum(int num, boolean good) {
            if (num == 0) {
                return good;
            }
            int take = num % 10;
            if (take == 0 || take == 1 || take == 8) {
                // 自己
                return goodNum(num / 10, good);
            }
            if (take == 3 || take == 4 || take == 7) {
                // 无效
                return false;
            }
            if (take == 2 || take == 5 || take == 6 || take == 9) {
                // 镜像 进位判断高位
                return goodNum(num / 10, true);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
