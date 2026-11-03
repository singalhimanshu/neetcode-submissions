class TrieNode<T> {
    private boolean isCompleteWord;
    private final Map<T, TrieNode> children;

    public TrieNode() {
        this.isCompleteWord = false;
        this.children = new HashMap<>();
    } 

    public boolean getIsCompleteWord() {
        return this.isCompleteWord;
    }

    public void setIsCompleteWord(boolean isCompleteWord) {
        this.isCompleteWord = isCompleteWord;
    }

    public boolean containsChild(T key) {
        return this.children.containsKey(key);
    }

    public void addChild(T key, TrieNode child) {
        this.children.put(key, child);
    }

    public TrieNode getChild(T key) {
        return this.children.get(key);
    }
}

class PrefixTree {
    private final TrieNode<Character> root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.containsChild(c)) {
                cur.addChild(c, new TrieNode());
            }
            cur = cur.getChild(c);
        }
        cur.setIsCompleteWord(true);
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.containsChild(c)) {
                return false;
            }
            cur = cur.getChild(c);
        }
        return cur.getIsCompleteWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.containsChild(c)) {
                return false;
            }
            cur = cur.getChild(c);
        }
        return true;
    }
}
