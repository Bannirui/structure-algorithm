/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int len=0; // 字符串长度
        int cnt=0; // 单词数量
        if(s==null||(len=s.length())==0 || words==null || (cnt=words.length)==0) return ret;
        int piece=words[0].length(); // 单词长度
        // 单词计数
        Map<String,Integer> map=new HashMap<>();
        for(String word: words) map.put(word, map.getOrDefault(word,0)+1);

        for(int i=0, bound=len-cnt*piece;i<=bound;i++){
            // [i...j]
            int j=i+cnt*piece;
            if(j>len) break;
            String tmpS = s.substring(i,j);
            Map<String, Integer> tmpMap = new HashMap<>(map);
            for(int k=0;k<=j-i-piece;k+=piece){
                String tmpWord = tmpS.substring(k,k+piece);
                if(!tmpMap.containsKey(tmpWord)) break;
                else{
                    int curCnt = tmpMap.get(tmpWord);
                    if(curCnt==1) tmpMap.remove(tmpWord);
                    else tmpMap.put(tmpWord, curCnt-1);
                }
            }
            if(tmpMap.isEmpty()) ret.add(i);
        }
        return ret;
    }
}
// @lc code=end

