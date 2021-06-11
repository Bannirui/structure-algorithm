package leetcode.editor.cn;

//给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：num = 5
//输出：2
//解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
//
//
// 示例 2：
//
//
//输入：num = 1
//输出：0
//解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
//
//
//
//
// 提示：
//
//
// 给定的整数 num 保证在 32 位带符号整数的范围内。
// num >= 1
// 你可以假定二进制数不包含前导零位。
// 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
//
// Related Topics 位运算
// 👍 214 👎 0

public class NumberComplement {
    public static void main(String[] args) {
        Solution solution = new NumberComplement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findComplement(int num) {
            /**
             * 输入: 0000 1001 1010
             * 输出: 0000 0110 0101
             *
             * 输入的最高位前的高位都不用管 全是0
             * 找到输入的最高位 用1填满最高位及低位
             * 异或一下
             */
            // 找最高位的1
            int highestOne = 0;
            int tmp = num;
            while (tmp != 0) {
                highestOne++;
                tmp >>>= 1;
            }
            int support = 1 << highestOne;
            return num ^ (support - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
