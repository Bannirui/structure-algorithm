package leetcode.editor.cn;

//给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
//
// 如果不能形成任何面积不为零的三角形，返回 0。
//
//
//
//
//
//
// 示例 1：
//
// 输入：[2,1,2]
//输出：5
//
//
// 示例 2：
//
// 输入：[1,2,1]
//输出：0
//
//
// 示例 3：
//
// 输入：[3,2,3,4]
//输出：10
//
//
// 示例 4：
//
// 输入：[3,6,2,3]
//输出：8
//
//
//
//
// 提示：
//
//
// 3 <= A.length <= 10000
// 1 <= A[i] <= 10^6
//
// Related Topics 排序 数学
// 👍 143 👎 0

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        Solution solution = new LargestPerimeterTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestPerimeter(int[] nums) {
            // 两个条件：三角形 最大周长
            if (nums == null || nums.length < 3) {
                return 0;
            }
            // 边长排序
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 2; i--) {
                if ((nums[i - 2] + nums[i - 1]) > nums[i]) {
                    // 构成三角形
                    return (nums[i - 2] + nums[i - 1] + nums[i]);
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
