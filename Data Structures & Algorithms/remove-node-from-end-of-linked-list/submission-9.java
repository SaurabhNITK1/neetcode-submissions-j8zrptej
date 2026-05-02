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
        ListNode dummy = new ListNode();
        dummy.next = head;
    
        
        // move temp n positions ahead, make sure that n shouldn't become null during this;
        int count = 0;
        while(count < n && dummy != null) {
            dummy = dummy.next;
            count++;
        }

       

        // Take one more pointer *temp == new ListNode such that temp.next = head and ierate both *dummy and *temp till temp becomes null.
        // Now you need to remove the node next to temp. If you take *temp == new ListNode such that temp = head then u need to remove the
        // node at temp itself. so act smartly
        ListNode temp = new ListNode();
        temp.next = head;
        while (dummy.next != null) {
            temp = temp.next;
            dummy = dummy.next;
        }

        // remove node
        if (temp.next == head) {
             head = head.next;       // usecase where you need to remove head
             return head;
        }
        temp.next = temp.next.next;  // remove the node next to this *temp pointer
        return head;
    }
}
