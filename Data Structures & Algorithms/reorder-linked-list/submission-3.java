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
        ListNode mid = findMid(head);
        ListNode reverse = reverseList(mid);

        ListNode l1 = head;
        ListNode l2 = reverse;
        while(l2.next != null){
            ListNode temp = l1.next;
            l1.next = l2;
            l1 = temp;

            temp = l2.next;
            l2.next = l1;
            l2 = temp;
        }
    }

    public ListNode findMid(ListNode head) {
        ListNode fp = head;
        ListNode sp = head;
        while(fp != null && fp.next != null){
            fp = fp.next.next;
            sp = sp.next;        
        }
        return sp;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
