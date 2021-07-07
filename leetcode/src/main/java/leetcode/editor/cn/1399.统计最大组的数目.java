import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-07 15:27:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 15:38:24
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1399 lang=java
 *
 * [1399] 统计最大组的数目
 */

// @lc code=start
class Solution {
    public int countLargestGroup(int n) {
        // 准备n个桶存放十进制各位和
        int bits = this.bits(n);
        int[] bins = new int[(9 * bits) + 1];
        // 各位和放桶
        for (int i = 1; i <= n; i++) {
            int sum = this.sum(i);
            bins[sum]++;
        }
        // 升序
        Arrays.sort(bins);
        int res = 1;
        for (int i = bins.length - 2; i >= 0; i--) {
            if (bins[i] == bins[bins.length - 1]) {
                res++;
            }
        }
        return res;
    }

    // num的各位和
    private int sum(int num) {
        int res = 0;
        while (num != 0) {
            int left = num % 10;
            res += left;
            num /= 10;
        }
        return res;
    }

    // num十进制有几位
    private int bits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
// @lc code=end
