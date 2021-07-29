/*
 * @Author: dingrui
 * @Date: 2021-07-29 18:02:13
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 23:06:31
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    // 字典树节点
    static class Trie {
        private Trie[] children;
        private boolean end = false;

        public Trie() {
            this.children = new Trie[26];
        }
    }

    // 字典树
    private Trie trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        Trie curTrie = trie;
        for (int i = 0; i < word.length(); i++) {
            if (curTrie.children[word.charAt(i) - 'a'] == null) {
                curTrie.children[word.charAt(i) - 'a'] = new Trie();
            }
            curTrie = curTrie.children[word.charAt(i) - 'a'];
        }
        curTrie.end = true;
    }

    public boolean search(String word) {
        Trie curTrie = this.trie;
        return this.dfs(word, 0, curTrie);
    }

    private boolean dfs(String word, int index, Trie trie) {
        // base case
        if (index == word.length()) {
            return trie.end;
        }
        // 当前字符
        char curChar = word.charAt(index);
        if (curChar == '.') {
            // 匹配任意字符
            for (int i = 0; i < 26; i++) {
                if (trie.children[i] != null) {
                    if (dfs(word, index + 1, trie.children[i])) {
                        // 随便匹配成功一个字符串都行
                        return true;
                    }
                }
            }
        } else {
            if (trie.children[curChar - 'a'] != null) {
                // 继续向下
                if (dfs(word, index + 1, trie.children[curChar - 'a'])) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
