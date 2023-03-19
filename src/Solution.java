import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode curr) {
        if (index == word.length()) {
            return curr.isEndOfWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : curr.children.values()) {
                if (searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = curr.children.get(c);
            if (child == null) {
                return false;
            }
            return searchHelper(word, index + 1, child);
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        WordDictionary wordDict = new WordDictionary();

        // Add some words to the dictionary
        wordDict.addWord("apple");
        wordDict.addWord("banana");
        wordDict.addWord("cherry");
        wordDict.addWord("durian");

        // Test searching for existing and non-existing words
        System.out.println(wordDict.search("apple"));  // true
        System.out.println(wordDict.search("banana")); // true
        System.out.println(wordDict.search("cherry")); // true
        System.out.println(wordDict.search("durian")); // true
        System.out.println(wordDict.search("grape"));  // false
        System.out.println(wordDict.search("pear"));   // false

        // Test searching with dots
        System.out.println(wordDict.search("a..le"));  // true
        System.out.println(wordDict.search("b.n.n.")); // true
        System.out.println(wordDict.search("..err.")); // true
        System.out.println(wordDict.search("d..i..")); // true
        System.out.println(wordDict.search("g...e"));  // false
        System.out.println(wordDict.search("p..r"));   // false
    }


}
