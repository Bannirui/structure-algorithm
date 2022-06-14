/*
 * @lc app=leetcode.cn id=717 lang=java
 *
 * [717] 1比特与2比特字符
 */

// @lc code=start
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len=0;
        if(bits==null || (len=bits.length)==0 || bits[len-1]!=0) throw new IllegalArgumentException();
        int i=0;
        for(;i<len-1;){
            if(bits[i]==0) i++;
            else i+=2;
        }
        return i==len-1;
    }
}
// @lc code=end

