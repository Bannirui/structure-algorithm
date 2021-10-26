import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        // 排序 降序
        Integer[] numArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArr[i] = nums[i];
        }
        Arrays.sort(numArr, (num1, num2) -> {
            // num1num2
            // num2num1
            return this.add(num2, num1) - this.add(num1, num2);
        });
        // 拼接字符串
        if (numArr[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : numArr) {
            sb.append(num);
        }
        return sb.toString();
    }

    // 数字长度
    private int len4Num(int num) {
        if (num == 0) {
            return 1;
        }
        int len = 0;
        while (num != 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    // 拼接两个数字 n1n2的顺序
    private int add(int n1, int n2) {
        // n2的长度
        int len = this.len4Num(n2);
        while (len != 0) {
            len--;
            n1 *= 10;
        }
        return n1 + n2;
    }
}
// @lc code=end
