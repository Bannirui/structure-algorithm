/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    private static class TrieNode{
        // 前缀
        private int preCnt;
        // 结尾
        private int endCnt;
        // 子节点
        private TrieNode[] children = new TrieNode[26];

        public TrieNode(){}
    }

    private TrieNode root=new TrieNode();

    public Trie() {

    }
    
    public void insert(String word) {
        TrieNode curNode = this.root;
        for(int i=0;i<word.length();i++){
            char curChar = word.charAt(i);
            if(curNode.children[curChar-'a']==null){
                // 新建
                curNode.children[curChar-'a']=new TrieNode();
            }
            // 指针后移
            curNode = curNode.children[curChar-'a'];
            // 前缀+1
            curNode.preCnt++;
        }
        // 整个字符串遍历结束 结尾+1
        curNode.endCnt++;
    }
    
    public boolean search(String word) {
        if(this.root==null){
            return false;
        }
        TrieNode curNode = this.root;
        for(int i=0;i<word.length();i++){
            char curChar = word.charAt(i);
            if(curNode.children[curChar-'a']==null){
                // 不存在节点
                return false;
            }
            curNode=curNode.children[curChar-'a'];
        }
        // 字符遍历完 确认是否以最后的字符结尾
        return curNode.endCnt>0;
    }
    
    public boolean startsWith(String prefix) {
        if(this.root==null){
            return false;
        }
        TrieNode curNode = this.root;
        for(int i=0;i<prefix.length();i++){
            char curChar = prefix.charAt(i);
            if(curNode.children[curChar-'a']==null){
                // 不存在节点
                return false;
            }
            curNode=curNode.children[curChar-'a'];
        }
        // 字符遍历完
        return curNode.preCnt>0; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

