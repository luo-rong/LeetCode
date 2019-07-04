package _208_ImplementTriePrefixTree;

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

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        TrieNode[] trieNodes = new TrieNode[2];
        System.out.println(trieNodes[0] == null);
    }
}