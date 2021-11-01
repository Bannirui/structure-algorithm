/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 窗口 [l...r] 扩 缩
        int r=-1;
        // 窗口内字符计数
        Set<Character> visited = new HashSet<>();
        int res=0;
        // 以i开头
        for(int i=0;i<s.length();i++){
            if(i!=0){
                // 左指针后移 就将出现过的字符移除
                visited.remove(s.charAt(i-1));
            }
            // 尝试扩张右指针
            while(r+1<s.length() && !visited.contains(s.charAt(r+1))){
                visited.add(s.charAt(r+1));
                r++;
            }
            // 收集子串长度
            res = Math.max(res, r-i+1);
        }
        return res;
    }
}
// @lc code=end

