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
Use hashMap to store the address or

Take fast pointer and slow pointer. move fast pointer by 2 position and slow pointer 
by 1 position. if there is a cycle these should never go to null and should intersect
at some point.

Why this should intersect?
Lets say there is a cycle and fast pointer will obviously enter the cycle first then followed
by slow pointer. Lets say there is a gap of 5 when both entered the cycle. Slow pointer moves by
one step while fast pointer moves by two steps. So the gap becomes 4. So you see here the gap
keeps on decrementing by 1 like 5,4,3,2,1,0. At some point of time the gap becomes zero. Hence 
they will definitely intersect.
**/
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head, fastPtr = head;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (fastPtr != null && slowPtr.val == fastPtr.val) return true;
        }
        return false;
    }
}
