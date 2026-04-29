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
       // find mid
       ListNode slow = head, fast = head;

       while (fast != null && fast.next!= null) {
          slow = slow.next;
          fast = fast.next.next;
       }
       // Slow will be at mid for odd sized list and for even sozed list also, slow will be dividing the linked list 
       // into two halves such that left half's size is always greater than or equal to right half's size. slow.next
       // will be the beginning of 2nd haf of array.


       // Reverse the 2nd half.
       ListNode prev = null;
       ListNode curr = slow.next;
       slow.next = null; // dereference to separate two lists
       while (curr != null) {
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }

       // prev is the head of the reversed list. Now merge the 2nd list into first
       ListNode head1 = head; // save head of the list to be merged
       ListNode head2 = prev;        
       while (head2 != null) {             // you know that 2nd list is smaller
           ListNode temp1 = head1.next;   // next element of list1
           ListNode temp2 = head2.next;    // next element of list2
        

           head1.next = head2;
           head2.next= temp1;

           head1 = temp1;
           head2 = temp2;
       }
    }
}
