/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start
class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int k = 30; k >= 0; k--) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                seen.add(num >> k);
            }
            int nextRes = (res << 1) + 1;
            boolean found = false;
            for (int num : nums) {
                if (seen.contains(nextRes ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if (found) {
                res = nextRes;
            } else {
                res = nextRes - 1;
            }
        }
        return res;
    }
}
// @lc code=end
