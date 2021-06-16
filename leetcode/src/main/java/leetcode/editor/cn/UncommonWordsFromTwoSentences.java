package leetcode.editor.cn;

//给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
//
// 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
//
// 返回所有不常用单词的列表。
//
// 您可以按任何顺序返回列表。
//
//
//
//
//
//
// 示例 1：
//
// 输入：A = "this apple is sweet", B = "this apple is sour"
//输出：["sweet","sour"]
//
//
// 示例 2：
//
// 输入：A = "apple apple", B = "banana"
//输出：["banana"]
//
//
//
//
// 提示：
//
//
// 0 <= A.length <= 200
// 0 <= B.length <= 200
// A 和 B 都只包含空格和小写字母。
//
// Related Topics 哈希表
// 👍 88 👎 0

import java.util.*;

public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            String[] s1Arr = s1.split("\\s+");
            String[] s2Arr = s2.split("\\s+");
            Map<String, Integer> countMap = new HashMap<>();
            for (String s1Ele : s1Arr) {
                countMap.put(s1Ele, countMap.getOrDefault(s1Ele, 0) + 1);
            }
            for (String s2Ele : s2Arr) {
                countMap.put(s2Ele, countMap.getOrDefault(s2Ele, 0) + 1);
            }
            List<String> resList = new ArrayList<>();
            // 遍历
            countMap.forEach((key, value) -> {
                if (value == 1) {
                    resList.add(key);
                }
            });
            // 转数组
            String[] res = new String[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
