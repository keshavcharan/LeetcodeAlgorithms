// Given a reference of a node in a connected undirected graph.
// Return a deep copy (clone) of the graph.

class CloneGraph {
    public Node cloneGraph(Node node) {
        Node head = new Node(-1);
        head.neighbors.add(cloneHelper(node, new HashMap<Integer, Node>()));
        return head.neighbors.get(0);
    }
 
    public Node cloneHelper(Node node, Map<Integer, Node> visited) {
        if(node == null)    return null;
        if(visited.containsKey(node.val))   return visited.get(node.val);
 
        Node clone = new Node(node.val);
        visited.put(node.val, clone);
 
        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneHelper(neighbor, visited));
        }
        return clone;
    }
}