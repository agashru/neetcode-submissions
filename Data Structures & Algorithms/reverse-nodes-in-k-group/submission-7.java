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
    ListNode th;
    ListNode tl;

    public int countNodes(ListNode curr){
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    public void addFirst(ListNode curr){
        if(th == null){
            th = curr;
            tl = curr;
        } else{
            curr.next = th;
            th = curr;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode curr = head;
        ListNode oh = null;
        ListNode ot = null;
        int count = countNodes(curr);
        while(count >= k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode fwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = fwd;
            }
            if(oh == null){
                oh = th;
                ot = tl;
            } else{
                ot.next = th;
                ot = tl;
            }
            tl = null;
            th = null;
            count = count - k;
        }
        ot.next = curr;
        return oh;
    }
}
