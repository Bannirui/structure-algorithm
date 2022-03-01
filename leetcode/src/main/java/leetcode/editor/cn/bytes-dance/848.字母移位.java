/*
 * @lc app=leetcode.cn id=848 lang=java
 *
 * [848] 字母移位
 */

// @lc code=start
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int cnt=0;
        for(int shift: shifts) cnt=(cnt+shift)%26;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char curCh = s.charAt(i);
            int curIdx = curCh-'a';
            char newCh = (char)(((curIdx+cnt)%26)+'a');
            sb.append(newCh);
            cnt=Math.floorMod(cnt-shifts[i],26);
        }
        return sb.toString();
    }
}
// @lc code=end

