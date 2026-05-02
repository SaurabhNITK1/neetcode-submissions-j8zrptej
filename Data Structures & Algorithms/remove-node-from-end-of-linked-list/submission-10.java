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

/* Algo:

1. Dummy node handles head deletion
   Add a fake node before the head so that even the head has a “previous” node.
   This removes the need for special cases when the first node must be deleted.


2. Fast moves n + 1 steps ahead
   Move fast n + 1 positions to create a gap of exactly n nodes between fast and slow.
   This guarantees slow will stop just before the node we want to remove.


3. Slow stops just before the node to delete
   When fast reaches null (end of list), slow is positioned at the node right before the target node.
   The node to be deleted may be the head itself / middle node / last node.


4. Always delete slow.next
   The node to remove is always slow.next, never slow itself.
   If the head must be deleted, slow and dummy will be pointing to same node and slow.next will be the head. when you delete slow.next,
   head also gets deleted and dummy gets the new reference.


5. Return dummy.next as the new head to take care of the usecase where head itself is deleted.
   Since the original head may have been removed, the correct new head is always dummy.next.
   When you delete slow.next, head also gets deleted and dummy.next also gets updated (point 4);

*/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete node
        slow.next = slow.next.next;
        return dummy.next;
    }
}
