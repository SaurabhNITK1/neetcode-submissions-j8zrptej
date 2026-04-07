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
Algo: 
1. You need to reverse the node holding current pointer.
2. Think of reversing head, how can you achieve ? you need to point head to null
   Think of algo: 
   Need to save the reference of next node
   reverse current -> current should point to prev
   once reversal done, prev needs to move forward
   also current needs to move forward.
   This algo applies for every node. I ll just explain next node of head and last node of 
   liked list as those are important to understand.
   
3. Now similarly think to reverse node next to head. you need to point it to head
4. When you do the reversal of links, you dereference or loose hold of next node. use next
   to save the reference of next node.
5. Now think of reversing the last node ? you need to reverse till the current becomes null
   (you cant check next == null bcz then you will not be able to reverse the last node)
   as current pointer is the one who is actually reversing nodes
6. Once last node is reversed, current will point to null. 
   Hence you need to return prev.
**/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head, next = head;
        while(next != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    }
}
