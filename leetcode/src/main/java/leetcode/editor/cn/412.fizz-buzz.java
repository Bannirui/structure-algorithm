/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        // 遍历
        // [1...n]
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // 规则1
                res.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                // 规则2
                res.add("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                // 规则3
                res.add("Buzz");
                continue;
            }
            // 规则4
            res.add("" + i);
        }
        return res;
    }
}
// @lc code=end
