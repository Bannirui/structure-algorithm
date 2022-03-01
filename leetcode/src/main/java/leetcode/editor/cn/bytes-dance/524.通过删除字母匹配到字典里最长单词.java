/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        if(s==null) throw new IllegalArgumentException();
        if(dictionary==null || dictionary.size()==0) return "";
        Collections.sort(dictionary, (s1, s2)->{
            int l1=s1.length();
            int l2=s2.length();
            return l1==l2?s1.compareTo(s2):l2-l1;
        });

        for(String d: dictionary){
            int sIdx=0, dIdx=0;
            while(sIdx<s.length() && dIdx<d.length()){
                if(s.charAt(sIdx)==d.charAt(dIdx)) dIdx++;
                sIdx++;
            }
            if(dIdx==d.length()) return d;
        }
        return "";
    }
}
// @lc code=end

