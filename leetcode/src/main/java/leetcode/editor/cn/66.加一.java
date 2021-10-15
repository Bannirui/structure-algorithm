import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution
{
    public int[] plusOne(int[] digits)
    {
        Deque<Integer> q = new LinkedList<>();
        // 从后往前遍历数组
        int carry = 0;
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            int sum = digits[i] + carry + add;
            carry = sum / 10;
            add = 0;
            q.offerLast(sum % 10);
        }
        // 收集结果
        if (carry != 0)
        {
            q.offerLast(carry);
        }
        int size = q.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++)
        {
            res[i] = q.pollLast();
        }
        return res;
    }
}
// @lc code=end
