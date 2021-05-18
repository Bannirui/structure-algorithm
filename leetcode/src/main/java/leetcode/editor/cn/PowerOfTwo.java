package leetcode.editor.cn;

//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
//输出: true
//解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
//输出: true
//解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
//输出: false
// Related Topics 位运算 数学
// 👍 297 👎 0

public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            // 2的幂次方什么特点 int32位只有1位是1 其余都是0 Integer.bitCount
            if (n == 0) {
                return false;
            }
            long m = (long) n;
            return (m & (-m)) == m;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
