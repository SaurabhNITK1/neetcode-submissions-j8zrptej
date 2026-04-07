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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
           List<Integer> temp = new ArrayList<>();
           int tempListSize = queue.size();
           for(int i=0; i<tempListSize; i++) {
             TreeNode node = queue.peek();
             if(node.left!=null) queue.offer(node.left);
             if(node.right!=null) queue.offer(node.right);
             temp.add(queue.poll().val);
           }
           levelOrder.add(temp);
        }
    return levelOrder;
    }
}
