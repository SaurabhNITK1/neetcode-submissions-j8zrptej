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
1. Take a queue and push root into it initially
2. To output nodes at each level capture the queue size in a variable
3. Add the nodes till the captured queue size (since you have already captured the queue size
   addition of new elements wont impact in the ongoing while loop iteration and only going to impact in next while loop iteration)
4. Using this fact, add the non null left and right childs at each iteration of for loop
5. Remove the node from the queue finally
6. Once the queue size is processed add it to the main return list to return
**/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
           List<Integer> temp = new ArrayList<>();
           int tempListSize = queue.size(); // capture queue size
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
