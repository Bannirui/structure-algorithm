import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        // 哈希表存储26个字符的行号
        Map<Character, Integer> map = new HashMap<>();
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);
        // 遍历每一个单词的每一个字符 转为小写
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            if (lowerWord.length() == 1) {
                res.add(word);
                continue;
            } else {
                boolean sameLine = true;
                for (int i = 1; i < lowerWord.length(); i++) {
                    if (!map.get(lowerWord.charAt(i)).equals(map.get(lowerWord.charAt(i - 1)))) {
                        sameLine = false;
                        break;
                    }
                }
                if (sameLine) {
                    res.add(word);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
// @lc code=end
