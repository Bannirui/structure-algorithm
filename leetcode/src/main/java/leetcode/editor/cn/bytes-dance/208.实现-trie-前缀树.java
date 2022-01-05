/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    private Node root;

    public Trie() {
        if(this.root==null){
            this.root=new Node();
        }
    }
    
    public void insert(String word) {
        if(this.root==null) throw new RuntimeException("err");
        int len=0; // the length of str
        if(word==null || (len=word.length())==0) return; // ignore
        Node curNode = this.root;
        for(int i=0; i<len; i++){ // iterator the str
            if(curNode.children==null){
                curNode.children = new Node[26];
            }
            if(curNode.children[word.charAt(i)-'a']==null){
                // create a node for ch since iterator
                curNode.children[word.charAt(i)-'a'] = new Node();
            }
            // mark prefix
            curNode = curNode.children[word.charAt(i)-'a'];
            curNode.preCnt++;
        }
        // mark suffix
        curNode.sufCnt++;
    }
    
    public boolean search(String word) {
        int len=0;
        if(word==null ||(len=word.length())==0) throw new RuntimeException("err");
        if(this.root==null) return false;
        Node curNode = this.root;
        for(int i=0; i<len; i++){
            if(curNode.children==null) return false;
            if(curNode.children[word.charAt(i)-'a']==null) return false;
            curNode = curNode.children[word.charAt(i)-'a'];
        }
        // check if end-with this str
        return curNode.sufCnt>0;
    }
    
    public boolean startsWith(String prefix) {
        int len=0;
        if(prefix==null || (len=prefix.length())==0) throw new RuntimeException("err");
        if(this.root==null) return false;
        Node curNode = this.root;
        for(int i=0; i<len; i++){
            if(curNode.children==null) return false;
            if(curNode.children[prefix.charAt(i)-'a']==null) return false;
            curNode = curNode.children[prefix.charAt(i)-'a'];
        }
        // check if start-with this str
        return curNode.preCnt>0;
    }

    // Trie node
    private static class Node{
        private Node[] children=new Node[26];
        private int preCnt=0;
        private int sufCnt=0;

        public Node(){

        }
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

