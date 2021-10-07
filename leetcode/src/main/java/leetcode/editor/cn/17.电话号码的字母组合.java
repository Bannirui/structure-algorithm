import java.util.Collections;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    private String digits;
    private Map<Character, String> map;
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 2-9
        int len = 0;
        if (digits == null || (len = digits.length()) == 0) {
            return Collections.EMPTY_LIST;
        }
        this.digits = digits;
        this.map = new HashMap<Character, String>();
        this.map.put('2', "abc");
        this.map.put('3', "def");
        this.map.put('4', "ghi");
        this.map.put('5', "jkl");
        this.map.put('6', "mno");
        this.map.put('7', "pqrs");
        this.map.put('8', "tuv");
        this.map.put('9', "wxyz");
        this.dfs(0, new StringBuilder());
        return this.res;
    }

    private void dfs(int idx, StringBuilder path) {
        // base case
        if (idx == digits.length()) {
            // 收集答案
            this.res.add(new String(path));
            return;
        }
        // 当前idx代表的数字
        char curChar = this.digits.charAt(idx);
        // 数字映射的字符串
        String curStr = this.map.get(curChar);
        if (curStr == null) {
            return;
        }
        for (int i = 0; i < curStr.length(); i++) {
            // 回溯时恢复现场
            StringBuilder newPath = new StringBuilder(path);
            newPath.append(curStr.charAt(i));
            this.dfs(idx + 1, newPath);
        }
    }
}
// @lc code=end
