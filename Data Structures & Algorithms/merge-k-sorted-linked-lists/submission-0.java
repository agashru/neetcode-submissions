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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        return mergeUsingDivideConquer(lists, 0, lists.length -1);
    }

    private ListNode mergeUsingDivideConquer(ListNode[] lists, int si, int ei){
        if(si > ei){
            return null;
        }

        if(si == ei){
            return lists[si];
        }
        int mid = (si + ei) / 2;
        ListNode l1 = mergeUsingDivideConquer(lists, si, mid);
        ListNode l2 = mergeUsingDivideConquer(lists, mid + 1, ei);

        return mergeTwoSortedLists(l1, l2);
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(-1);
        ListNode dummy = dummyNode;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            } else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if(l1 != null){
            dummy.next = l1;
        }

        if(l2 != null){
            dummy.next = l2;
        }
        return dummyNode.next;
    }
}
