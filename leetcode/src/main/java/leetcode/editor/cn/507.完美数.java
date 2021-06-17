import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        // 找到所有因子 求和 两倍
        boolean[] res = new boolean[num + 1];
        findSub(num, res);
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            if (res[i]) {
                sum += i;
            }
        }
        return (sum >>> 1) == num;
    }

    public void findSub(int num, boolean[] res) {
        for (int i = 1; i * i <= num; i++) {
            if (!res[i] && (num % i == 0)) {
                res[i] = true;
                res[num / i] = true;
            }
        }
    }
}
// @lc code=end
