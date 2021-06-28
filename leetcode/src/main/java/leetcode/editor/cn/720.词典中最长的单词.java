import java.io.PushbackInputStream;
import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-06-23 13:09:13
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 13:11:58
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 */

// @lc code=start
class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie(words);
        // 所有单词放到前缀树上
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        // 深度优先进行遍历
        return trie.dfs();
    }

    // 前缀树节点
    class TrieNode {
        // 以此节点为经过路径的数量
        private int path;
        // 以此节点为结尾的单词的数量
        private int end;
        // 以此节点为结尾的单词的数组脚标 最后一次添加的
        private String lastWord;
        private TrieNode[] map;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.lastWord = "";
            this.map = new TrieNode[26];
        }
    }

    // 字典树
    class Trie {
        // 根节点 空节点
        private TrieNode root;

        // 所有的单词
        private String[] words;

        public Trie(String[] words) {
            this.root = new TrieNode();
            this.words = words;
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = this.root;
            // map中的数组脚标
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                node.path++;
            }
            node.end++;
            node.lastWord = word;
        }

        public String dfs() {
            Stack<TrieNode> stack = new Stack<>();
            stack.push(this.root);
            String res = "";
            while (!stack.isEmpty()) {
                // 出栈
                TrieNode node = stack.pop();
                // root节点单独处理
                if (node == this.root) {
                    TrieNode[] map = node.map;
                    for (TrieNode n : map) {
                        if (n != null) {
                            stack.push(n);
                        }
                    }
                }
                if (node.end != 0) {
                    // 有单词以此字符为结尾
                    String curWord = node.lastWord;
                    if (curWord.length() > res.length()
                            || (curWord.length() == res.length() && curWord.compareTo(res) < 0)) {
                        res = curWord;
                    }
                    // 如果没有以字符结尾 就没必要继续查找了 不然找出来的单词也不是由数组中其他单词组成的
                    TrieNode[] map = node.map;
                    for (TrieNode n : map) {
                        if (n != null) {
                            stack.push(n);
                        }
                    }
                }

            }
            return res;
        }
    }
}
// @lc code=end
