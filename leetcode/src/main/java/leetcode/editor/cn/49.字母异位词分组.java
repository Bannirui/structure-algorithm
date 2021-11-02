/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 异位词的字典序一样
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            // 字典序
            String sortedStr = this.sortedStr(str);
            List<String> strList = map.getOrDefault(sortedStr,new ArrayList<String>());
            strList.add(str);
            map.put(sortedStr, strList);
        }
        // 遍历map
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    // 字典序
    private String sortedStr(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
// @lc code=end

