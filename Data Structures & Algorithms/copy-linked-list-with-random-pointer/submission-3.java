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
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }

        curr = head;
        while(curr != null){
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        Node old = head;
        Node secondNode = head.next;
        Node second = head.next;

        while(old != null){
            old.next = old.next.next;
            second.next = (second.next != null) ? second.next.next : null;
            old = old.next;
            second = second.next; 
        }
        return secondNode;
    }
}
