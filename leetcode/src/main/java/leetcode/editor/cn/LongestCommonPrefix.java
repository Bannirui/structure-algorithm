package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1386 👎 0

public class LongestCommonPrefix {
	public static void main(String[] args) {
		Solution solution = new LongestCommonPrefix().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * @author dingrui
	 * @date 2020-12-14
	 * @description 分治
	 */
	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0) {
				return "";
			} else {
				return longestCommonPrefix(strs, 0, strs.length-1);
			}
		}

		private String longestCommonPrefix(String[] strs, int start, int end) {
			if (start == end) {
				return strs[start];
			} else {
				int mid = start + (end - start) / 2;
				String left = longestCommonPrefix(strs, start, mid);
				String right = longestCommonPrefix(strs, mid + 1, end);
				return commonPrefix(left, right);
			}
		}

		private String commonPrefix(String left, String right) {
			if (left.length() == 0 || right.length() == 0) {
				return "";
			}
			int index = 0;
			while (index < Math.min(left.length(), right.length())) {
				if (left.charAt(index) != right.charAt(index)) {
					break;
				}
				index++;
			}
			return left.substring(0, index);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}