# Design add and search Data structure

 a programming problem where one is to design a data structure that supports adding new words and finding if a string matches any previously added string.

## Problem Statement

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the `WordDictionary` class:

- `WordDictionary()` Initializes the object.
- `void addWord(word)` Adds `word` to the data structure, it can be matched later.
- `bool search(word)` Returns `true` if there is any string in the data structure that matches `word` or `false` otherwise. `word` may contain dots `'.'` where dots can be matched with any letter.

**Example:**

**Input**
```["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]] ```
**Output**
```[null,null,null,null,false,true,true,true]```

**Explanation**
```WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True```

## Explanation & Solution

The implementation uses a Trie data structure to store the words. The `TrieNode` class represents a node in the Trie, with a map of child nodes and a flag indicating whether the node represents the end of a word. The `WordDictionary` class has two methods: `addWord` to add a word to the Trie, and `search` to search for a word in the Trie.

The `addWord` method traverses the Trie starting from the root and adding new nodes as needed for each character in the word. It sets the `isEndOfWord` flag to true for the last node in the word.

The `search` method recursively searches the Trie starting from the root and following the path corresponding to the characters in the word. If a dot is encountered, it recursively searches all child nodes. The search stops when the end of the word is reached, and the method returns true if the last node has the `isEndOfWord` flag set to true.

Note that this implementation is not the most optimized, and could be further improved in terms of space and time complexity.
