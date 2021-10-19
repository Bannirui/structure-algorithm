import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution
{
    public String minWindow(String s, String t)
    {
        // 目标字符串t中的字符计数
        Map<Character, Integer> targetCnt = new HashMap<>();
        Map<Character, Integer> cmpCnt = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
        {
            targetCnt.put(t.charAt(i), targetCnt.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 窗口左右指针
        int l = 0, r = -1;
        // 结果的左右指针
        int L = -1, R = -1;
        // 中间结果的字符串长度
        int len = Integer.MAX_VALUE;
        while (r < s.length())
        {
            // 扩张
            r++;
            // 扩张进来的字符统计
            if (r < s.length() && targetCnt.containsKey(s.charAt(r)))
            {
                cmpCnt.put(s.charAt(r), cmpCnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            // 尝试收缩窗口
            while (l <= r && valid(targetCnt, cmpCnt))
            {
                if (r - l + 1 < len)
                {
                    // 结果唯一 不需要考虑r-l+1=len的情况
                    // 找到了更小的字符串满足要求
                    len = r - l + 1;
                    L = l;
                    R = r;
                }
                // 移除缩容的那个字符统计
                if (cmpCnt.containsKey(s.charAt(l)))
                {
                    cmpCnt.put(s.charAt(l), cmpCnt.getOrDefault(s.charAt(l), 1) - 1);
                }
                // 缩容
                l++;
            }
        }
        // 窗口右指针判断
        return R == -1 ? "" : s.substring(L, R + 1);
    }

    private boolean valid(Map<Character, Integer> targetCnt, Map<Character, Integer> cmpCnt)
    {
        for (Map.Entry<Character, Integer> entry : targetCnt.entrySet())
        {
            if (cmpCnt.getOrDefault(entry.getKey(), 0) < entry.getValue())
            {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
