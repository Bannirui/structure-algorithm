import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {

    // 生成字符串的结果
    List<String> res = new ArrayList<>();

    // 检索单词
    Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordSet = new HashSet<String>(wordDict);
        this.trace(s, 0, new ArrayList<String>());
        return this.res;
    }

    private void trace(String src, int i, List<String> path) {
        // base case
        if (i == src.length()) {
            // 收集答案
            if (!path.isEmpty()) {
                String tmpRes = new ArrayList<String>(path).stream().collect(Collectors.joining(" "));
                this.res.add(tmpRes);
            }
            return;
        }
        // path是收集[0...i-1]的答案 从i继续收集
        for (int end = i; end < src.length(); end++) {
            // [i...end]
            String curStr = src.substring(i, end + 1);
            if (this.wordSet.contains(curStr)) {
                // 替代现场还原
                List<String> newPath = new ArrayList<String>(path) {
                    {
                        add(curStr);
                    }
                };
                this.trace(src, end + 1, newPath);
            }
        }
    }
}
// @lc code=end
