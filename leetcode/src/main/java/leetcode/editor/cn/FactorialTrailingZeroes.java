package leetcode.editor.cn;

//给定一个整数 n，返回 n! 结果尾数中零的数量。
//
// 示例 1:
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。
//
// 示例 2:
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零.
//
// 说明: 你算法的时间复杂度应为 O(log n) 。
// Related Topics 数学
// 👍 439 👎 0

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        // solution.trailingZeroes(125);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            /**
             * 1!=1 -> 0
             * 2!=2*1 -> 2
             * 3!=3*2*1=6 -> 0
             * 4!=4*3*2*1=24 -> 0
             * 5!=5*4*3*2*1=120 -> 1
             * 6!=6*5*4*3*2*1=720 -> 1
             * 7!=7*6*5*4*3*2*1=5040 -> 1
             * ...
             * n!=
             * 有几对2跟5 5出现的次数少于2出现的次数 组队的次数取决于5
             * 有几个5
             *
             * for循环里面套while直接就运行超时了
             */
            int count = 0;
            while (n > 0) {
                count += n / 5;
                n /= 5;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
