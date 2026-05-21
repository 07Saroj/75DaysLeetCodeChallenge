import java.util.ArrayList;
import java.util.List;

class Solution {
    // Define the TrieNode structure
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Stores the complete word at the leaf node
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        // Step 1: Build the Trie
        TrieNode root = buildTrie(words);
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Step 2: Iterate through every cell on the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }
        
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c];
        
        // If the character is already visited ('#') or doesn't exist in the Trie, stop
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }
        
        // Move to the next node in the Trie
        node = node.children[ch - 'a'];
        
        // If we found a matching word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Mark as null to avoid adding duplicate entries
        }
        
        // Mark the current cell as visited
        board[r][c] = '#';
        
        // Explore the 4 neighboring directions (Up, Down, Left, Right)
        if (r > 0) dfs(board, r - 1, c, node, result);                 // Up
        if (r < board.length - 1) dfs(board, r + 1, c, node, result);   // Down
        if (c > 0) dfs(board, r, c - 1, node, result);                 // Left
        if (c < board[0].length - 1) dfs(board, r, c + 1, node, result); // Right
        
        // Backtrack: Restore the original character
        board[r][c] = ch;
    }

    // Helper method to insert all words into the Trie
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char ch : w.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = w; // Store the full word at the end of the path
        }
        return root;
    }
}