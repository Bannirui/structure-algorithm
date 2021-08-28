/*
 * @Author: dingRui
 * @Date: 2021-07-27 09:47:40
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-28 17:01:47
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        long num = n;
        // 几位数
        long size = 1;
        // 多少个几位数
        long counts = 9;

        while (num > 0) {
            if (num - size * counts > 0) {
                // 继续扩大1位数
                num -= (size * counts);
                size++;
                counts *= 10;
            } else {
                // 当前判断size位数 num表示的就是在size为数中第几位
                // 定位第几个数
                long index = num / size;
                // 表示已经定位到第几个数 继续定位第几位
                long mod = num % size;
                // size位开头的数
                long start = (long) Math.pow(10, size - 1);
                if (mod == 0) {
                    // [start...]第index个数的最后一位
                    int end = (int) (start + index - 1);
                    return end % 10;
                } else {
                    // [start...]第index+1个数的第mod位
                    long end = start + (index + 1) - 1;
                    return (int) (end / (long) Math.pow(10, size - mod)) % 10;
                }
            }
        }
        return 0;
    }
}
// @lc code=end
