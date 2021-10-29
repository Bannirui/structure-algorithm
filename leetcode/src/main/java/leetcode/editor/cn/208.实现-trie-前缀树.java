/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    private static class TrieNode {
        // 前缀树节点不存储字符
        // 以字符结尾的单词数量
        private int endCnt = 0;
        // 当前字符之前的前缀单词数量
        private int prefixCnt = 0;
        // 子节点 26个字符各自对应
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {

        }
    }

    private TrieNode root;

    public Trie() {
        // 根节点
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (this.root == null || word == null) {
            return;
        }
        // 指针
        TrieNode cur = this.root;
        // 遍历每个字符 创建对应的节点
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            // 节点是否已经存在
            if (cur.children[curChar - 'a'] == null) {
                // 创建
                cur.children[curChar - 'a'] = new TrieNode();
            }
            // 指针后移
            cur = cur.children[curChar - 'a'];
            // 前缀增加
            cur.prefixCnt++;
        }
        // 单词字符遍历结束
        cur.endCnt++;
    }

    public boolean search(String word) {
        // base case
        if (this.root == null || word == null) {
            return false;
        }
        // 遍历所有字符 找到最后一个字符结尾的单词
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            TrieNode nextNode = cur.children[curChar - 'a'];
            if (nextNode == null) {
                // 但凡出现一个字符的节点不存在 就说明不存在该完整字符串
                return false;
            } else {
                cur = nextNode;
            }
        }
        // 所有字符遍历完 cur来到了最后一个字符节点 找出以最后一个字符结尾的单词数量
        return cur.endCnt > 0;
    }

    public boolean startsWith(String prefix) {
        // base case
        if (this.root == null || prefix == null) {
            return false;
        }
        TrieNode cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char curChar = prefix.charAt(i);
            TrieNode nextNode = cur.children[curChar - 'a'];
            if (nextNode == null) {
                // 当前完整单词不存在
                return false;
            } else {
                // 向下移动指针
                cur = nextNode;
            }
        }
        // cur来到了单词末尾的下一个
        return cur.prefixCnt > 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
