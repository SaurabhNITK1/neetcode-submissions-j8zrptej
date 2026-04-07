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
Algorithm:
1. Take a dummy node and point it to back of head to store the head as head will be modified in this case
2. Take another two pointers which will be used to track groupPrev Node and groupNextNode
3. Reverse every k node
4. UPdate the  groupPrev Node and groupNextNode
**/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        
        while(true) {
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break; // processed all the k groups

            // Reverse the linkedList upto k nodes
            ListNode prev = kth.next, current = groupPrev.next;
            ListNode groupNext = kth.next;
            while(current != groupNext) {
               ListNode next = current.next;
               current.next = prev;
               prev = current;
               current = next;
            }

            // Link nodes to move to next set of k groups
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;

    }

    private ListNode getKthNode(ListNode curr, int k) {
       while(curr != null && k>0) {
         curr = curr.next;
         k--;
       }
       return curr;
    }
}
