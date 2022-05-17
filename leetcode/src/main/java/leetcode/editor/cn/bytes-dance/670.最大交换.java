/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        if(num<0) throw new IllegalArgumentException();
        if(num==0) return 0;
        String s = String.valueOf(num);
        char[] chArr = s.toCharArray();
        // 0...9 the las idx occurs in num
        int[] lastIdxTable = new int[10];
        for(int i=0,len=chArr.length;i<len;i++) lastIdxTable[chArr[i]-'0']=i;
        
        for(int i=0,len=chArr.length;i<len;i++){
            char curCh=chArr[i];
            for(int n=9;n>(curCh-'0');n--){
                int lastIdx = lastIdxTable[n];
                if(lastIdx > i){
                    char tmp = chArr[i];
                    chArr[i]=chArr[lastIdx];
                    chArr[lastIdx]=tmp;
                    return Integer.parseInt(new String(chArr));
                }
            }
        }
        return num;
    }
}
// @lc code=end

