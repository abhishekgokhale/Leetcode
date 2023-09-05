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

class Solution {
    Map<Node, Node> maps = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node newHead = new Node(0);
        Node curr = head;
        Node newNode = newHead;
        while(curr != null){
            if(!maps.containsKey(curr))
                maps.put(curr, new Node(curr.val));
            newNode.next = maps.get(curr);
            newNode = newNode.next;
            if(curr.random != null){
                if(!maps.containsKey(curr.random))
                    maps.put(curr.random, new Node(curr.random.val));
                newNode.random = maps.get(curr.random);
            }
            curr = curr.next;
        }
        return newHead.next;
    }
}