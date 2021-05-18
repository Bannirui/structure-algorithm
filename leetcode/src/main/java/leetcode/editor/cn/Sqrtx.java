package leetcode.editor.cn;

//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 568 👎 0

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        // int i = solution.mySqrt(2147395599);
        // System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            // 这最蠢的肯定就是对range(0,x)进行二分查找 数学角度来讲肯定没必要 如果x很大就会损耗很大的性能
            // 使用非递归式二分查找
            int left = 0;
            int right = x;
            int res = -1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                // 两个整型平方会溢出 转Long
                if ((long) mid * mid > x) {
                    // 肯定在左边
                    right = mid - 1;
                } else {
                    // 可能在右边
                    res = mid;
                    left = mid + 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}