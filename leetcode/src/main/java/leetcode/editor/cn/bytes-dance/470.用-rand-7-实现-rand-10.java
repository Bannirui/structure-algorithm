/*
 * @lc app=leetcode.cn id=470 lang=java
 *
 * [470] 用 Rand7() 实现 Rand10()
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int idx;
        do{
            int row=rand7();
            int col=rand7();
            // [1...49]
            idx=col+(row-1)*7;
        }while(idx>40);
        // idx [1...40]
        return 1+(idx-1)%10;
    }
}
// @lc code=end

