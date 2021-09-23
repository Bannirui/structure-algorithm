import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> bankSet = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        for (String b : bank) {
            bankSet.add(b);
        }
        // 基因库中不包含目标 无法转换 返回-1
        if (!bankSet.contains(end)) {
            return -1;
        }
        int counts = 0;
        return this.bfs(startSet, endSet, bankSet, counts);
    }

    // 款搜
    private int bfs(Set<String> startSet, Set<String> endSet, Set<String> bankSet, int counts) {
        // base case
        if (startSet.isEmpty()) {
            return -1;
        }
        // 深搜从小集合开始
        if (startSet.size() > endSet.size()) {
            return this.bfs(endSet, startSet, bankSet, counts);
        }
        Set<String> nextStartSet = new HashSet<>();
        char[] candidate = new char[] { 'A', 'C', 'G', 'T' };
        // 遍历起始集合
        for (String start : startSet) {
            // 遍历当前基因字符串的各个字符
            for (int i = 0; i < start.length(); i++) {
                // 可以变换的字符
                for (int j = 0; j < candidate.length; j++) {
                    // 当前基因字符与待交换字符不一样就可以进行一次变换
                    if (start.charAt(i) != candidate[j]) {
                        // 拷贝当前基因串
                        StringBuilder changedStart = new StringBuilder(start);
                        // 基因串变换后结果
                        changedStart.setCharAt(i, candidate[j]);
                        String changedStartStr = changedStart.toString();
                        // 已经转换为了目标序列 当前的转换次数就是最少的
                        if (endSet.contains(changedStartStr)) {
                            return counts + 1;
                        } else {
                            // 转过过程中形成的基因序列是合法的话就可以继续下一轮深搜
                            if (bankSet.contains(changedStartStr)) {
                                nextStartSet.add(changedStartStr);
                            }
                        }
                    }
                }
            }
        }
        // 下一轮深搜
        return this.bfs(nextStartSet, endSet, bankSet, counts + 1);
    }
}
// @lc code=end
