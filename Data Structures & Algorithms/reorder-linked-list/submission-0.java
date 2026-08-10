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
    public void reorderList(ListNode head) {      
        ListNode midNode = findMidNode(head);
        ListNode curr = reverseList(midNode);

        ListNode l1 = head;
        ListNode l2 = curr;

        while(l2.next != null){
            ListNode temp = l1.next;
            l1.next = l2;
            l1 = temp;

            temp = l2.next;
            l2.next = l1;
            l2 = temp;
        }

    }

    private ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
