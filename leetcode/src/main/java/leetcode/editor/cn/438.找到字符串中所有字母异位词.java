/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lenP = p.length();
        char[] pCharArr = p.toCharArray();
        Arrays.sort(pCharArr);
        String sortP = new String(pCharArr);
        for(int i=0; i<=s.length()-lenP; i++){
            // 截取s中字符串 [i...j]
            int j=i+lenP;
            String subS = s.substring(i, j);
            char[] subSCharArr = subS.toCharArray();
            Arrays.sort(subSCharArr);
            String sortSubS = new String(subSCharArr);
            if(Objects.equals(sortP,sortSubS)){
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

