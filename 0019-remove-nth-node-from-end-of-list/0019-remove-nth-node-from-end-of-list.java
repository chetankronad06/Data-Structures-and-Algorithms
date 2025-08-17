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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (n == length) {
            return head.next;
        }
        int steps = length - n;
        ListNode prev = head;
        for (int i = 1; i < steps; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return head;
    }
}