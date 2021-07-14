import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-14 16:00:49
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 18:16:43
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    List<String> res = new ArrayList<>();
    String[] map = new String[10];
    int limitPathLength = 0;

    public List<String> letterCombinations(String digits) {
        // base case
        if (digits.length() == 0) {
            return this.res;
        }
        // map初始化 按键-字符
        this.map[2] = "abc";
        this.map[3] = "def";
        this.map[4] = "ghi";
        this.map[5] = "jkl";
        this.map[6] = "mno";
        this.map[7] = "pqrs";
        this.map[8] = "tuv";
        this.map[9] = "wxyz";
        this.limitPathLength = digits.length();
        // map中字符串的字符是否被决策
        boolean[] letterUsed = new boolean[26];
        // 数字中的字符是否被决策过
        boolean[] digitUsed = new boolean[digits.length()];
        dfs(digits.toCharArray(), 0, "", digitUsed, letterUsed);
        return this.res;
    }

    // digits
    // start 从digits脚标开始
    // path
    // digitUsed digit是否被决策
    // letterUsed digit对应的字母串是否被决策
    private void dfs(char[] digits, int start, String path, boolean[] digitUsed, boolean[] letterUsed) {
        // base case
        if (path.length() == this.limitPathLength) {
            // 收集结果
            this.res.add(new String(path));
            return;
        }
        for (int i = start; i < digits.length; i++) {
            if (!digitUsed[i]) {
                // 替代现场恢复
                boolean[] copyDigitUsed = this.copyArr(digitUsed);
                copyDigitUsed[i] = true;

                String letter = this.map[digits[i] - '0'];
                // 任选一个字符
                for (int j = 0; j < letter.length(); j++) {
                    char letterChar = letter.charAt(j);
                    if (!letterUsed[letterChar - 'a']) {
                        String copyPath = new String(path) + letterChar;
                        boolean[] copyLetterUsed = this.copyArr(letterUsed);
                        dfs(digits, i + 1, copyPath, copyDigitUsed, copyLetterUsed);
                    }
                }
            }
        }

    }

    private boolean[] copyArr(boolean[] arr) {
        boolean[] res = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
// @lc code=end
