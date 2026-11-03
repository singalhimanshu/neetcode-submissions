/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        final Map<Node, Node> copyMap = new HashMap<>();
        return dfsAndCopy(node, copyMap);
    }

    private Node dfsAndCopy(Node node, final Map<Node, Node> copyMap) {
        if (copyMap.get(node) != null) {
            return copyMap.get(node);
        }
        final Node copyNode = new Node(node.val);
        copyMap.put(node, copyNode);
        for (Node neigh : node.neighbors) {
            copyNode.neighbors.add(dfsAndCopy(neigh, copyMap));
        }
        return copyNode;
    }
}