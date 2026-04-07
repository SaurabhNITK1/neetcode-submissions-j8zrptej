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

/**
Good basic example of top down recursion
swap the left child and right child
recursilvely call the invertTree on children
**/
class Solution {
    public TreeNode invertTree(TreeNode root) {
       if(root==null) return null; // base case
       //swap (do the operation on parents, top down approach)
       TreeNode temp = new TreeNode();
       temp = root.left;
       root.left = root.right;
       root.right = temp;

       root.left = invertTree(root.left);
       root.right = invertTree(root.right);

       return root;
    }
}
