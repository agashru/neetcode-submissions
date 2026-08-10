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
    ListNode th = null;
    ListNode tl= null;
    public ListNode reverseKGroup(ListNode head, int k) {
        //check if head is null or single node or k = 0
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode curr = head;
        int length = countOfNodes(curr);
        ListNode oh = null;
        ListNode ot = null;
        while(length >= k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode temp = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = temp;
            }
            if(oh == null){
                oh = th;
                ot = tl;
            } else{
                ot.next = th;
                ot = tl;
            }
            length = length - k;
            th = null;
            tl = null;
        }
        ot.next = curr;
        return oh;
    }

    private int countOfNodes(ListNode head){
            ListNode curr = head;
            int count = 0;
            while(curr != null){
                curr = curr.next;
                count++;
            }
            return count;
    }

    private void addFirstNode(ListNode node){
        if(th == null){
            th = node;
            tl = node; 
        } else{
            node.next = th;
            th = node;
        }
    }
}
