/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) throw new IllegalArgumentException();
        List<Integer> cntL = new ArrayList<>();
        int i=0;
        while(i<len)
        {
            char curCh = s.charAt(i);
            int curCnt=0;
            while(i<len&&curCh==s.charAt(i))
            {
                curCnt++;
                i++;
            }
            cntL.add(curCnt);
        }
        int ret=0;
        for(int j=1;j<cntL.size();j++) ret+=Math.min(cntL.get(j-1),cntL.get(j));
        return ret;
    }
}
// @lc code=end

