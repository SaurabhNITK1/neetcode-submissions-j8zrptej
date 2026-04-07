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
1. Take a pointer dummy node to store the head and initialoze it with [0]
2. Take another pointer named 'node' which is used to track the already merged list. Initialize it with dummy node.
   The 'node' should always be one step behind l1 or l2 to ensure that l1 or l2 can be appended in 'node'.
4. Keep on appending the 'node' with  l1 and l2 turn by turn based on which one's head is smaller. 
   Keep on incrementing node by one at the end of every append to track already merged list.
5. return dummy.next as dummy points to [0].
**/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(list1!=null && list2!=null) {
            if(list1.val<=list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if(list1 != null) {
            node.next = list1;
        } else if (list2 != null) {
            node.next = list2;
        }
        return dummy.next;
    }
}