/*
 * @Author: dingrui
 * @Date: 2021-07-29 16:15:54
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 17:24:08
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    // 子节点
    private Trie[] children;
    // 当前节点是不是某个单词的结尾
    private boolean end;

    /** Initialize your data structure here. */
    public Trie() {
        this.children = new Trie[26];
        this.end = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curNode = this;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (curNode.children[curChar - 'a'] == null) {
                // 新建节点
                curNode.children[curChar - 'a'] = new Trie();
            } else {
                // 该节点已经存在
            }
            // 节点指针下移
            curNode = curNode.children[curChar - 'a'];
        }
        // 遍历完了 最后一个节点设置结束标识符
        curNode.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie lastNode = this.searchPre(word);
        if (lastNode != null && lastNode.end) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie lastNode = this.searchPre(prefix);
        if (lastNode != null) {
            return true;
        } else {
            return false;
        }
    }

    private Trie searchPre(String word) {
        Trie curNode = this;
        for (int i = 0; i < word.length(); i++) {
            if (curNode.children[word.charAt(i) - 'a'] == null) {
                // 不存在
                return null;
            } else {
                // 存在节点 当前节点的指针下移
                curNode = curNode.children[word.charAt(i) - 'a'];
            }
        }
        return curNode;
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
