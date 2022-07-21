/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */

// @lc code=start
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // ax+by=z
        if(jug1Capacity+jug2Capacity<targetCapacity) return false;
        if(jug1Capacity==0 || jug2Capacity==0) return targetCapacity==0 || jug1Capacity+jug2Capacity==targetCapacity;
        return targetCapacity%this.gcd(jug1Capacity, jug2Capacity)==0;
    }

    // 辗转相除 最大公约数
    private int gcd(int x, int y){
        if(x<y) return this.gcd(y,x);
        return (x%y==0)?y:this.gcd(y, x%y);
    }
}
// @lc code=end

