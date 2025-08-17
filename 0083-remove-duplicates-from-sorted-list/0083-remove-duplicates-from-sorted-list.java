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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        int vis = curr.val;
        while(curr.next!=null){
            if(curr.next.val == vis){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
            vis = curr.val;
        }
        return head;
        
    }
}