[题目描述](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)

实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

**注意**
1. 前缀树：Trie树，即字典树，又称单词查找树或键树，是一种树形结构，是一种哈希树的变种。   
![image](https://images0.cnblogs.com/blog/440499/201308/05224450-851bf5fb62b245eb970d274ac2d43518.jpg)
2. `search()`空指针判断！！！

```java
class TrieNode {
    private static final int LENGTH_NUM = 26;

    TrieNode(boolean isStr) {
        this.isStr = isStr;
        this.next = new TrieNode[LENGTH_NUM];
    }

    boolean isStr;
    TrieNode[] next;
}

class Trie {
    private TrieNode boot;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        boot = new TrieNode(false);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = boot;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode(false);
            }
            node = node.next[index];
        }
        node.isStr = true;
    }

    private TrieNode prefixMatch(String prefix) {
        TrieNode node = boot;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (node.next[index] == null) {
                return null;
            }
            node = node.next[index];
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = prefixMatch(word);
        return node != null && node.isStr;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return prefixMatch(prefix) != null;
    }
}
```