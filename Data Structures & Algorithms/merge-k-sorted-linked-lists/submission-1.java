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
/*
Algo is similar to merge two linked list. In merge two linked list since we have only two elements to compare
we can do comparision using if-else in O(1) time so overall time complexity for two lists comes out to be O(n) 
but here we have k elements and we need to use heap to track the minimum element. So the comparision time is O(logn)
Total time is n.O(logn)
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val-b.val);

       for(ListNode list : lists) {
          minHeap.offer(list);
       }

       ListNode res = new ListNode(0);
       ListNode curr = res;

       while(!minHeap.isEmpty()) {
         ListNode node = minHeap.poll();
         curr.next = node; // merge
         curr = curr.next;
         node = node.next;

         if(node != null) {
            minHeap.offer(node);
         }
       }

       return res.next;
    }
}
