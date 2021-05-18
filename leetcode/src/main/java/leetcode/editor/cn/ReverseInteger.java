package leetcode.editor.cn;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2396 👎 0

public class ReverseInteger {
	public static void main(String[] args) {
		Solution solution = new ReverseInteger().new Solution();
		// int reverse = new ReverseInteger().new Solution().reverse(123);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int reverse(int x) {
			int res = 0;
			while (x != 0) {
				// 进行进位操作之前判断当前结果数字是否已经越界
				if (res * 10 / 10 != res) {
					// 下面逻辑的进位是通过num*10+tmp来操作的 所以判断num*10是否溢出就行 首先假设nun*10已经溢出 那么jvm会自动转型大精度 转型后的结果再除以10 想除结果就是大精度而不是整型了 这个结果再跟自己原先比较 一定不成立
					res = 0;
					break;
				}
				// 进行进位操作
				int tmp = x % 10;
				res = res * 10 + tmp;
				x /= 10;
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}