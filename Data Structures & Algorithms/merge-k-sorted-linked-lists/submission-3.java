/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
Divide and conquer.
1. Divide till it left becomes a single list and right also becomes a separate single list
2. After that merge these two (conquer) and return the merged list.
**/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists == null || lists.length==0) return null;
       return divide(lists, 0, lists.length-1);
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        //base case
        if(l == r) return lists[l];

        // find pivot or mid
        int mid = l + (r-l)/2;

        // divide along pivot (the base case is one node in left , one node in right)
        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid+1, r);
        
        // merge
        return conquer(left, right);
    }

    // conquer method here merges two lists
    private ListNode conquer(ListNode left, ListNode right) {
        ListNode result = new ListNode(0); // To track head to return the result at end
        ListNode current = result; // current to track value that is already processed

        while (left != null && right != null) {
            if(left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                // right is greater than left
                current.next = right;
                right = right.next;
            }
            current = current.next; // current tracks the value already processed
        }

        // If one of the left or right becomes null means one of the node is processed. In such case append the 
        // remaining node at the end.
        if(left == null) {
            current.next = right;
        } else if (right == null) {
            current.next = left;
        }

        return result.next;
    }
}
