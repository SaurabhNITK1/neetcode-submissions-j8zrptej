/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/**
Algo:
Two pass approach:
1. In first pass just copy the nodes using new (deep copy) and don't create any links.
   Maintain a hash which Maps original node to its copy. This hash will be used to create
   links.
2. In second pass create the links using hashMap;
**/
class Solution {
    public Node copyRandomList(Node head) {
        Node itr = head;
        Map<Node, Node> hash = new HashMap<>();

        Node copy;
        // First pass
        while(itr != null) {
            copy = new Node(itr.val);
            hash.put(itr, copy);
            itr = itr.next;
        }

        // 2nd pass. In this pass also we iterate over original list
        // and create links to the copy list
        itr = head; // using same itr to iterate in 2nd pass
        while(itr != null) {
           copy = hash.get(itr);
           copy.next = hash.get(itr.next);
           copy.random = hash.get(itr.random);
           itr = itr.next;
        }

        // Now we need to return the head of copy, we can use hash to get this head as well
        return hash.get(head);
    }
}
