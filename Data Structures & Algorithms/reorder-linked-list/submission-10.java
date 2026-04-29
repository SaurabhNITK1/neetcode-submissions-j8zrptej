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
/*Algo: (See the comments in code itself that will help more)
   Find the middle, reverse the second half, and merge the two halves alternately — all in place.
*/
class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }    // By this logic you know that 2nd half is always smaller or equal to first half and cant be greater

        // 2. Reverse the second half
        ListNode secondHalf = reverse(slow.next);
        slow.next = null; // split the list

        // 3. Merge two halves
        merge(head, secondHalf);
    }

    // Reverse a linked list and return new head
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Merge two lists alternately (L1, L2, L1, L2...)
    private void merge(ListNode head1, ListNode head2) {
        while (head2 != null) { // as you know by logic of finding mid that 2nd list is smaller 
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }
}
