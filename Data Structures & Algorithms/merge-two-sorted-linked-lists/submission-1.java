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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode();
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode cur;
        if (cur1.val < cur2.val) {
            dummy.next = cur1;
            cur = cur1;
            cur1 = cur1.next;
        } else {
            dummy.next = cur2;
            cur = cur2;
            cur2 = cur2.next;
        }
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                ListNode tmp = cur1.next;
                cur.next = cur1;
                cur = cur.next;
                cur1 = tmp;
            } else {
                ListNode tmp = cur2.next;
                cur.next = cur2;
                cur = cur.next;
                cur2 = tmp;
            }
        }
        while (cur1 != null) {
            ListNode tmp = cur1.next;
            cur.next = cur1;
            cur = cur.next;
            cur1 = tmp;
        }
        while (cur2 != null) {
            ListNode tmp = cur2.next;
            cur.next = cur2;
            cur = cur.next;
            cur2 = tmp;
        }
        return dummy.next;
    }
}