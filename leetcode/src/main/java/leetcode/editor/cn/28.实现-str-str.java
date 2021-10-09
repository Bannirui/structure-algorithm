import javax.swing.MenuElement;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution
{
    public int strStr(String haystack, String needle)
    {
        // base case
        int lenStr = haystack.length();
        int lenPat = needle.length();
        if (lenPat == 0)
        {
            return 0;
        }
        // kmp算法 求解pat的next数组 根据next数组在str中搜索
        int[] next = this.getNextByPat(needle);
        // 遍历匹配串str i下标永不回退 只根据next数组调整j下标
        for (int i = 0, j = 0; i < lenStr; i++)
        {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
            {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j))
            {
                j++;
            }
            if (j == lenPat)
            {
                // 模式串下标结束 完全匹配到
                return i - lenPat + 1;
            }
        }
        // 匹配串str遍历结束还没找到模式串pat
        return -1;
    }

    // 根据模式串pat求解next数组
    private int[] getNextByPat(String pat)
    {
        int len = pat.length();
        int[] next = new int[len];
        // base case next[0]=0 声明数组时已经初始化
        // 遍历模式串
        for (int i = 1, j = 0; i < len; i++)
        {
            while (j > 0 && pat.charAt(i) != pat.charAt(j))
            {
                j = next[j - 1];
            }
            if (pat.charAt(i) == pat.charAt(j))
            {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
// @lc code=end
