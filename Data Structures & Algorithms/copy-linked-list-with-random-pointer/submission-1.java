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
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;
        while(curr != null){
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        Node oldList = head;
        Node newList = head.next;
        Node newHead = head.next;
        while(oldList != null){
            oldList.next = oldList.next.next;
            newList.next = (newList.next != null) ? newList.next.next : null;
            oldList = oldList.next;
            newList = newList.next;
        }
        return newHead;
    }
}
