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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDia = new int[1]; // creating array object as primitives are passed by value and objects by reference
        calculateHeight(root, maxDia);
        return maxDia[0];
    }


    private int calculateHeight(TreeNode root, int[] maxDia) {
        if(root==null) 
          return 0;
        
        int left = calculateHeight(root.left, maxDia);
        int right = calculateHeight(root.right, maxDia);
        maxDia[0] = Math.max(maxDia[0], left+right);
        return 1+ Math.max(left, right);
    }
}
