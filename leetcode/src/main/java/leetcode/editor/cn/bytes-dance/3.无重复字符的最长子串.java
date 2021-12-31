/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // corner condition
        int len=0;
        if(s==null || (len=s.length())==0) return 0;
        int r=-1; // the bound idx of slid window
        Set<Character> cnt = new HashSet<>(); // count for char in s
        int ret = Integer.MIN_VALUE; // record the max length
        // iterator
        for(int i=0; i<len; i++){ // [i...r] is the window
            if(i!=0){ // slid l
                cnt.remove(s.charAt(i-1));
            }
            while(r+1<len && !cnt.contains(s.charAt(r+1))){
                r++; // slid r
                cnt.add(s.charAt(r)); // add ele into set
            }
            ret = Math.max(ret, r-i+1);
        }
        return ret;
    }
}
// @lc code=end

