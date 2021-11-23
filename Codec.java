// Serialize and Deserialize

public class Codec {
 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)    return "null";        
        return serializeHelper(root);
    }
 
    private String serializeHelper(TreeNode node) {
        if(node == null)    return "null";        
        return Integer.toString(node.val) + "," + serializeHelper(node.left) + "," + serializeHelper(node.right);        
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> out = new LinkedList<String>(Arrays.asList(dataArray));
        return deserializeHelper(out);
    }
 
    private TreeNode deserializeHelper(List<String> dataArray) {
        if(dataArray.isEmpty()) return null;
        String val = dataArray.get(0);
        if(val.equals("null")) {     
            dataArray.remove(0);
            return null;  
        } 
        TreeNode node = new TreeNode(Integer.parseInt(val));
        dataArray.remove(0);
        node.left = deserializeHelper(dataArray);
        node.right = deserializeHelper(dataArray);
        return node;
    }
}