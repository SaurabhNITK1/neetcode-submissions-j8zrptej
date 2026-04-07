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
    int[] currentMax = new int[1];
    
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        count[0] = 0;
        return preOrder(root, root.val, count);
    }

    private int preOrder(TreeNode root, int currentMax, int[] count) {
      if(root == null) return 0;  
      if(root.val>=currentMax) {
        currentMax = root.val;
        count[0]++;
      }  
      preOrder(root.left, currentMax, count);
      preOrder(root.right, currentMax, count);
      return count[0];
    }
}
