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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if(n == 1) {
            // need to delete at tail
         }
         ListNode end = head;
         ListNode start = head;
         // iterate end initially by n
         for(int i=0; i<n; i++) {
            end = end.next;
         }

         if (end == null) {
            // usecase where you need to delete head
            head = head.next;
            return head;
         }
 
         // Now you maintain the gap while iterating till end reaches last. Once end reaches 
         // last start will be pointing to the node which next node we need to delete
         while(end.next != null) {
            start = start.next;
            end = end.next;
         }
         return deleteNextNode(head, start);
    }

    // deletes the next node
    private ListNode deleteNextNode(ListNode head, ListNode node) {
        if (node != null && node.next != null) {
           node.next = node.next.next;
        }
        return head;
    }
}
