/*
 * @lc app=leetcode.cn id=1647 lang=java
 *
 * [1647] 字符频次唯一的最小删除次数
 */

// @lc code=start
class Solution {
    public int minDeletions(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) return 0;
        int[] cnt=new int[26];
        for(int i=0;i<len;i++) cnt[s.charAt(i)-'a']++;
        Set<Integer> freqSet = new HashSet<>();
        int ret=0;
        for(int i=0;i<26;i++){
            int freq = cnt[i];
            if(freq==0) continue;
            while(freq>0){
                if(freqSet.contains(freq)){
                    freq--;
                    ret++;
                }else{
                    freqSet.add(freq);
                    break;
                }
            }
        }
        return ret;
    }
}
// @lc code=end

