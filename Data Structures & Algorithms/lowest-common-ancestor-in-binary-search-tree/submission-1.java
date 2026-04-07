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
Algo:
1. If p and q are on opposite side of a root, then root is the LCA
2. If p and q are on same side then LCA is in the subtree on that side, we need
to find it recursively.
**/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val <= root.val && q.val >= root.val || p.val >= root.val && q.val <= root.val) {
            return root;
        }
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
