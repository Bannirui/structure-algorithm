/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1=0, len2=0;
        if(s1==null || s2==null || (len1=s1.length())==0 || (len2=s2.length())==0) throw new IllegalArgumentException();
        if(len1>len2) return false;
        int[] cnt1=new int[26];
        int[] cnt2=new int[26];
        for(int i=0;i<len1;i++)
        {
            cnt1[s1.charAt(i)-'a']++;
            cnt2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(cnt1, cnt2)) return true;
        for(int i=len1;i<len2;i++)
        {
            cnt2[s2.charAt(i-len1)-'a']--;
            cnt2[s2.charAt(i)-'a']++;
            if(Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }
}
// @lc code=end

