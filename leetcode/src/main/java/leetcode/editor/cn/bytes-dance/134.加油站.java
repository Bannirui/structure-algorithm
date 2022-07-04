/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int lenGas=0, lenCost=0;
        if(gas==null || cost==null || (lenGas=gas.length)==0 || (lenCost=cost.length)==0 || lenGas!=lenCost) return -1;
        int i=0;
        while(i<lenGas){
            int sumGas=0, sumCost=0;
            int cnt=0;
            while(cnt<lenGas){
                int j=(i+cnt)%lenGas;
                sumGas+=gas[j];
                sumCost+=cost[j];
                if(sumCost>sumGas) break;
                cnt++;
            }
            if(cnt==lenGas) return i;
            else i=i+cnt+1;
        }
        return -1;
    }
}
// @lc code=end

