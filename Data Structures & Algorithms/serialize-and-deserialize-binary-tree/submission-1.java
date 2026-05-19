/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node == null){
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
    }

    return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if(data == null || data.isEmpty()) return null;

        String[] values = data.split(",");

    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
          int i = 1;

while(!queue.isEmpty()){
    TreeNode node = queue.poll();

    if(!values[i].equals("null")){
        TreeNode leftchild = new TreeNode(Integer.parseInt(values[i]));
        node.left = leftchild;
        queue.offer(leftchild);
    }
    i++;

    if(!values[i].equals("null")){
        TreeNode rightchild = new TreeNode(Integer.parseInt(values[i]));
        node.right = rightchild;
        queue.offer(rightchild);
    }
    i++;

}

return root;
    }
}
