package leetcode.editor.cn;

//给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
//
//
//
// 示例：
//
//
//输入：
//[1,2,3]
//输出：
//3
//解释：
//只需要3次操作（注意每次操作会增加两个元素的值）：
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
//
// Related Topics 数学
// 👍 216 👎 0

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums) {
            // 排序
            Arrays.sort(nums);
            int moves = 0;
            for (int i = 1; i < nums.length; i++) {
                int diff = nums[i] - nums[i - 1] + moves;
                nums[i] += moves;
                moves += diff;
            }
            return moves;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
