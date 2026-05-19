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

class Solution {
    int preIdx = 0;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode helper(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }

        int rootval = preorder[preIdx];
        preIdx++;

        TreeNode root = new TreeNode(rootval);

        int mid = map.get(rootval);

        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder,mid+1,right);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length - 1);
    }
}
