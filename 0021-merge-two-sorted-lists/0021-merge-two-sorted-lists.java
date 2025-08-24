class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // dummy head
        ListNode tail = dummy;             // pointer to build the result

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                tail.next = temp1;
                temp1 = temp1.next;
            } else {
                tail.next = temp2;
                temp2 = temp2.next;
            }
            tail = tail.next; // move forward
        }

        // attach the remaining nodes
        if (temp1 != null) {
            tail.next = temp1;
        }
        if (temp2 != null) {
            tail.next = temp2;
        }

        return dummy.next; // skip dummy
    }
}
