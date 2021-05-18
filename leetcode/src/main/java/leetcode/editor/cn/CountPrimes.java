package leetcode.editor.cn;

//统计所有小于非负整数 n 的质数的数量。
//
//
//
// 示例 1：
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
//
// 示例 2：
//
// 输入：n = 0
//输出：0
//
//
// 示例 3：
//
// 输入：n = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= n <= 5 * 106
//
// Related Topics 哈希表 数学
// 👍 648 👎 0

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        // int i = solution.countPrimes(10);
        // System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            // 质数的特点
            boolean[] isPrim = new boolean[n];
            Arrays.fill(isPrim, true);
            for (int i = 2; i * i < n; i++) {
                if (isPrim[i]) {
                    for (int j = i * i; j < n; j+=i) {
                        isPrim[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrim[i]) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
