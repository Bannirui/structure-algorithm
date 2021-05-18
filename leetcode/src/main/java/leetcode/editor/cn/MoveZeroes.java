package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 1010 👎 0

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            // 0移到最后 相对顺序 原地操作不拷贝 维护一个指针放非0的数字 另一个指针遍历
            int cur = 0;
            int notZero = 0;
            while (cur < nums.length) {
                if (nums[cur] != 0) {
                    int tmp = nums[cur];
                    nums[cur] = nums[notZero];
                    nums[notZero] = tmp;
                    notZero++;
                }
                cur++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
