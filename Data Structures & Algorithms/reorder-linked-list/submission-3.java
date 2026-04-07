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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // find the mid
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse
        // dont touch first half, reverse the 2nd half, slow.next marks the beginning of 2nd half
        // here slow acts as current node for 2nd half
        ListNode prev = null;
        ListNode current = slow.next; // Making 2nd half smaller will help doesnt impact the merge
        slow.next = null; // ** Mark the end of 1st list
        while(current!=null) { // reverse
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Merge the lists prev will point the 2nd list and head will point the first list
        ListNode first = head;
        ListNode second = prev; 
        prev = null;
        while (second != null) { // you know that 2nd list is smaller
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
