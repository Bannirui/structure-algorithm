package leetcode.editor.cn;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
// Related Topics 数组 双指针
// 👍 238 👎 0

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            // 找到中间索引 向两边扩散
            int len = nums.length;
            int[] res = new int[len];
            // 如果都是正数
            if (nums[0] >= 0) {
                for (int i = 0; i < len; i++) {
                    res[i] = nums[i] * nums[i];
                }
                return res;
            }
            // 如果都是负数
            if (nums[len - 1] <= 0) {
                for (int i = len - 1; i >= 0; i--) {
                    res[len - i - 1] = nums[i] * nums[i];
                }
                return res;
            }
            // 如果有正数 有负数 找到正负的分水岭
            int L = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] < 0) {
                    L = i;
                } else {
                    break;
                }
            }
            int R = L + 1;
            int index = 0;
            while (index < len || L >= 0 || R < len) {
                if (L >= 0 && R < len) {
                    int LL = nums[L] * nums[L];
                    int RR = nums[R] * nums[R];
                    if (LL <= RR) {
                        res[index++] = LL;
                        L--;
                    } else {
                        res[index++] = RR;
                        R++;
                    }
                } else if (L >= 0 && R >= len) {
                    // 右边越界
                    int LL = nums[L] * nums[L];
                    res[index++] = LL;
                    L--;
                } else {
                    // 左边越界
                    int RR = nums[R] * nums[R];
                    res[index++] = RR;
                    R++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
