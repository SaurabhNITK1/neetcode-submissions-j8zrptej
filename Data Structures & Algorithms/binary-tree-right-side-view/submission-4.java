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
1. Use level order traversal
2. Instead of adiing all the nodes while iterating the level, add only the last node
3. Once a level is iterated you will have a rightmost element. Add this to your final result
   and go to next level
**/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            int temp = 0;
            for(int i=0; i<queueSize; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(i==queueSize-1) {
                    temp = node.val;
                }
            }
            rightView.add(temp);
        }
        return rightView;
    }
}
