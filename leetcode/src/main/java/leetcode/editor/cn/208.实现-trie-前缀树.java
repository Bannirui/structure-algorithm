/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    // 前缀树根节点
    private Node root=new Node();

    public Trie() {

    }
    
    public void insert(String word) {
        if(this.root==null){
            this.root=new Node();
        }
        Node cur = this.root;
        for(int i=0; i<word.length(); i++){
            if(cur.children[word.charAt(i)-'a']==null){
                // 新建节点
                cur.children[word.charAt(i)-'a'] = new Node();
            }
            cur = cur.children[word.charAt(i)-'a'];
            cur.preCnt++;
        }
        cur.endCnt++;
    }
    
    public boolean search(String word) {
        if(this.root==null){
            return false;
        }
        Node cur = this.root;
        for(int i=0; i<word.length(); i++){
            if(cur.children[word.charAt(i)-'a']==null){
                // 不存在节点
                return false;
            }
            // 存在节点
            cur = cur.children[word.charAt(i)-'a'];
        }
        return cur.endCnt>0;
    }
    
    public boolean startsWith(String prefix) {
        if(this.root==null){
            return false;
        }
        Node cur = this.root;
        for(int i=0; i<prefix.length(); i++){
            if(cur.children[prefix.charAt(i)-'a']==null){
                // 不存在节点
                return false;
            }
            // 存在节点
            cur = cur.children[prefix.charAt(i)-'a'];
        }
        return cur.preCnt>0;
    }

    private static class Node{
        private int preCnt;
        private int endCnt;
        private Node[] children = new Node[26];

        public Node(){}
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

