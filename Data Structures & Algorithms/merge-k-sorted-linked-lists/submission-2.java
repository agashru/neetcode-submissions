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

        return merge(lists, 0 , lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int si , int ei){
        if(si > ei){
            return null;
        }

        if(si == ei){
            return lists[si];
        }

        int mid = si + (ei - si)/ 2;
        ListNode l1 = merge(lists, si, mid);
        ListNode l2 = merge(lists, mid + 1, ei);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode dummy = dummyNode;

        while(list1 != null && list2 != null){
           if(list1.val <= list2.val){
                dummy.next = list1;
                dummy = dummy.next;
                list1 = list1.next;
           } else {
                dummy.next = list2;
                dummy = dummy.next;
                list2 = list2.next;
           }
        }

        if(list1 != null){
            dummy.next = list1;
        }

        if(list2 != null){
            dummy.next = list2;
        }
        return dummyNode.next;
    }
}
