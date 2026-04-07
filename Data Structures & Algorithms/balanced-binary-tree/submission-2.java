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
Same algo as diameter one
**/
class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean[] answer = new boolean[1];
        answer[0] = true;
        calculateHeight(root, answer);
        return answer[0];
    }

    private int calculateHeight(TreeNode root, boolean[] answer) {
        if(root==null) return 0;
        int leftHeight = calculateHeight(root.left, answer);
        int rightHeight = calculateHeight(root.right, answer);
        if (Math.abs(leftHeight - rightHeight) > 1) {
           answer[0] = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
