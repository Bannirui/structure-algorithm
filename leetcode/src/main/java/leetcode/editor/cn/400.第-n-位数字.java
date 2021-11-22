/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        // 定位到几位数
        int bits=1;
        while(n>this.countN(bits)){  
            n-=this.countN(bits);
            bits++;
        }
        // bits位数 在第n个数字
        // 第几个数字
        int idx4Row = n/bits;
        // 这个数字的第几位
        int idx4Num = n%bits;
        // 找到数字
        int base = (int)Math.pow(10, bits-1);
        if(idx4Num==0){
            // 数字的最后一位
            return (int)(base+idx4Row-1)%10;
        }else{
            int tmp = (int)((base+idx4Row)/(Math.pow(10,bits-idx4Num)));
            return tmp%10;
        }
        
    }

    // n位数多少个数字
    // 2位 [10...99] 180个数字
    private int countN(int n) {
        return (int)(9*Math.pow(10, n-1)*n); 
    }
}
// @lc code=end

