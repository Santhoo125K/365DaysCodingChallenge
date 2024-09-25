class Solution {
    
    // TrieNode class representing each node in the Trie
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];  // Assuming only lowercase English letters
            isEndOfWord = false;
        }
    }

    // Trie class to insert and find the longest common prefix
    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        // Find the longest common prefix by traversing the Trie
        public String longestCommonPrefix() {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();

            while (countChildren(node) == 1 && !node.isEndOfWord) {
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        prefix.append((char)(i + 'a'));
                        node = node.children[i];
                        break;
                    }
                }
            }

            return prefix.toString();
        }

        // Helper function to count the number of children of a node
        private int countChildren(TrieNode node) {
            int count = 0;
            for (TrieNode child : node.children) {
                if (child != null) {
                    count++;
                }
            }
            return count;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        Trie trie = new Trie();

        // Insert each word into the Trie
        for (String word : strs) {
            trie.insert(word);
        }

        // Get the longest common prefix from the Trie
        return trie.longestCommonPrefix();
    }
}
