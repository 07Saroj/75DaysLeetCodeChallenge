class Trie {
    private class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode(){
            children = new TrieNode[26];
            isEndOfWord=false;
        }
    }

    private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int idx=c -'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];
        }
        curr.isEndOfWord=true;

    }
    
    public boolean search(String word) {
        return dfs(word,0,root);
    }

    boolean dfs(String word,int idx,TrieNode node){
        if(idx==word.length()){
            return node.isEndOfWord;
        }
        char c=word.charAt(idx);
        int i=c-'a';
        if(node.children[i]==null) return false;
        return dfs(word,idx+1,node.children[i]);
    }
    
    public boolean startsWith(String prefix) {

        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            int j=c-'a';
            if(curr.children[j]==null) return false;
            curr=curr.children[j];
        }
        return true;
    }

    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */