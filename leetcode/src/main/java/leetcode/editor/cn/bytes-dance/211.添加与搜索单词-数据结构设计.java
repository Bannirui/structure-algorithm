/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    private Trie root=new Trie();

    public WordDictionary() {
        if(this.root==null) this.root=new Trie();
    }
    
    public void addWord(String word) {
        this.root.insert(word);
    }
    
    public boolean search(String word) {
        return this.dfsSearch(word, 0, this.root);
    }

    private boolean dfsSearch(String word, int idx, Trie node){
        if(idx==word.length()) return node.isEnd();
        if(node==null||node.getChildren()==null) return false;
        char ch = word.charAt(idx);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                Trie child=node.getChildren()[i];
                if(child!=null&&dfsSearch(word,idx+1,child)) return true;
            }
        }else{
            Trie child = (node!=null&&node.getChildren()!=null)?node.getChildren()[ch-'a']:null;
            if(child!=null&&dfsSearch(word,idx+1,child)) return true;
        }
        return false;
    }

    private static class Trie{
        private Trie[] children = new Trie[26];
        private int suffixCnt=0;

        public Trie(){}

        public void insert(String word){
            int len=0;
            if(word==null || (len=word.length())==0) return;
            Trie curNode = this;
            for(int i=0;i<len;i++){
                if(curNode.children==null) curNode.children=new Trie[26];
                char curCh = word.charAt(i);
                if(curNode.children[curCh-'a']==null) curNode.children[curCh-'a']=new Trie();
                curNode = curNode.children[curCh-'a'];
            }
            curNode.suffixCnt++;
        }

        public Trie[] getChildren(){
            return this.children;
        }

        public int getSuffixCnt(){
            return this.suffixCnt;
        }

        public boolean isEnd(){
            return this.suffixCnt>0;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

